package au.com.noojee.acceloapi.dao.gson;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import au.com.noojee.acceloapi.AcceloFieldList;
import au.com.noojee.acceloapi.dao.ActivityOwnerType;
import au.com.noojee.acceloapi.entities.AcceloEntity;
import au.com.noojee.acceloapi.entities.Activity.Standing;
import au.com.noojee.acceloapi.entities.Priority;
import au.com.noojee.acceloapi.entities.types.AgainstType;
import au.com.noojee.acceloapi.util.Constants;
import au.com.noojee.acceloapi.util.Conversions;

public class GsonForAccelo
{
	static public <E extends AcceloEntity<E>> String toJson(AcceloEntity<E> e)
	{
		Gson gson = create();
		return gson.toJson(e);
	}

	static public <E extends AcceloEntity<E>> E fromJson(String json, Class<E> entityClass)
	{
		Gson gson = create();
		return gson.fromJson(json, entityClass);
	}

	static public <R> R fromJson(StringReader json, Class<R> responseClass)
	{
		Gson gson = create();
		return gson.fromJson(json, responseClass);
	}

	/**
	 * takes a list of field names and formats them into a json list. e.g. "_fields": ["status.title", "status.id",
	 * "status.color", "mobile"]
	 * 
	 * @param fieldNames
	 * @return
	 */
	public static String toJson(AcceloFieldList fieldList)
	{
		String json = "";
		boolean firstField = true;

		for (String field : fieldList.fields())
		{
			if (firstField)
			{
				json += "\"_fields\": [";
				firstField = false;
			}
			else
				json += ",";

			json += "\"" + field + "\"";

		}
		if (!firstField)
			json += "]";
		return json;
	}

	static private Gson create()
	{
		// Register type adaptors for special conversions and enums requiring a conversion.
		GsonBuilder builder = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
				.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
				.registerTypeAdapter(AgainstType.class, new AgainstTypeSerializer())
				.registerTypeAdapter(AgainstType.class, new AgainstTypeDeserializer())
				.registerTypeAdapter(ActivityOwnerType.class, new ActivityOwnerTypeSerializer())
				.registerTypeAdapter(ActivityOwnerType.class, new ActivityOwnerDeserializer())
				.registerTypeAdapter(Standing.class, new StandingSerializer())
				.registerTypeAdapter(Standing.class, new StandingDeserializer())
				.registerTypeAdapter(Priority.NoojeePriority.class, new PrioritySerializer())
				.registerTypeAdapter(Priority.NoojeePriority.class, new PriorityDeserializer());

		return builder.create();
	}

	/**
	 * Special Gson Adaptors for accelo types and some that gson doesn't support out of the box.
	 */

	/**
	 * LocalDate
	 */
	static private class LocalDateSerializer implements JsonSerializer<LocalDate>
	{

		public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context)
		{
			Long longDate = Conversions.toLong(date);
			return new JsonPrimitive(longDate.toString());
		}
	}

	static private class LocalDateDeserializer implements JsonDeserializer<LocalDate>
	{

		@Override
		public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			LocalDate localDate = Conversions.toLocalDate(json.getAsLong());

			return localDate;

		}
	}
	
	/**
	 * LocalDateTime
	 */
	static private class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime>
	{

		public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context)
		{
			Long longDate = Conversions.toLong(date);
			return new JsonPrimitive(longDate.toString());
		}
	}

	static private class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime>
	{

		@Override
		public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			LocalDateTime localDateTime = Conversions.toLocalDateTime(json.getAsLong());

			return localDateTime;

		}
	}


	/**
	 * AgainstType
	 */
	static private class AgainstTypeSerializer implements JsonSerializer<AgainstType>
	{

		public JsonElement serialize(AgainstType againstType, Type typeOfSrc, JsonSerializationContext context)
		{
			return new JsonPrimitive(againstType.getName());
		}
	}

	static private class AgainstTypeDeserializer implements JsonDeserializer<AgainstType>
	{

		@Override
		public AgainstType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			return AgainstType.valueOf(json.getAsString());
		}
	}

	/**
	 * ActivityOwnerType
	 */
	static private class ActivityOwnerTypeSerializer implements JsonSerializer<ActivityOwnerType>
	{

		public JsonElement serialize(ActivityOwnerType ownerType, Type typeOfSrc, JsonSerializationContext context)
		{
			return new JsonPrimitive(ownerType.name());
		}
	}

	static private class ActivityOwnerDeserializer implements JsonDeserializer<ActivityOwnerType>
	{
		@Override
		public ActivityOwnerType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			return ActivityOwnerType.valueOf(json.getAsString());
		}
	}

	/**
	 * Ticket.Priority
	 */
	static private class PrioritySerializer implements JsonSerializer<Priority.NoojeePriority>
	{

		public JsonElement serialize(Priority.NoojeePriority priority, Type typeOfSrc, JsonSerializationContext context)
		{
			return new JsonPrimitive(priority.getId());
		}
	}

	static private class PriorityDeserializer implements JsonDeserializer<Priority.NoojeePriority>
	{
		@Override
		public Priority.NoojeePriority deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			
			long id = json.getAsLong();

			return Priority.NoojeePriority.valueOf(id);
		}
	}

	/**
	 * Activity Standing
	 */
	static private class StandingSerializer implements JsonSerializer<Standing>
	{
		public JsonElement serialize(Standing ownerType, Type typeOfSrc, JsonSerializationContext context)
		{
			return new JsonPrimitive(ownerType.name());
		}
	}

	static private class StandingDeserializer implements JsonDeserializer<Standing>
	{
		@Override
		public Standing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			return Standing.valueOf(json.getAsString());
		}
	}

}
