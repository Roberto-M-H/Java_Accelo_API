package au.com.noojee.acceloapi.entities.meta;

import java.time.LocalDate;

/** 
 *
 *          DO NOT MODIFY 
 *
 * This code is generated by au.com.noojee.acceloapi.entities.meta.FieldMetaDataGenerator
 *
 * The generator use @AcceloField annotations to determine what fields to include in the Meta data.
 *
 *          DO NOT MODIFY 
 *
 */
import au.com.noojee.acceloapi.entities.Activity;
import au.com.noojee.acceloapi.entities.Activity.Medium;
import au.com.noojee.acceloapi.entities.Activity.Visibility;
import au.com.noojee.acceloapi.entities.generator.FilterField;


public class Activity_ 
{

	public static FilterField<Activity, Integer> _class = new FilterField<>("class"); 
	public static FilterField<Activity, Integer> against_id = new FilterField<>("against_id"); 
	public static FilterField<Activity, String> against_type = new FilterField<>("against_type"); 
	public static FilterField<Activity, LocalDate> date_created = new FilterField<>("date_created"); 
	public static FilterField<Activity, LocalDate> date_ended = new FilterField<>("date_ended"); 
	public static FilterField<Activity, LocalDate> date_logged = new FilterField<>("date_logged"); 
	public static FilterField<Activity, LocalDate> date_modified = new FilterField<>("date_modified"); 
	public static FilterField<Activity, LocalDate> date_started = new FilterField<>("date_started"); 
	public static FilterField<Activity, Integer> id = new FilterField<>("id"); 
	public static FilterField<Activity, Medium> medium = new FilterField<>("medium"); 
	public static FilterField<Activity, Integer> owner_id = new FilterField<>("owner_id"); 
	public static FilterField<Activity, String> owner_type = new FilterField<>("owner_type"); 
	public static FilterField<Activity, String> parent_id = new FilterField<>("parent_id"); 
	public static FilterField<Activity, Integer> priority = new FilterField<>("priority"); 
	public static FilterField<Activity, Integer> staff = new FilterField<>("staff"); 
	public static FilterField<Activity, Integer> task = new FilterField<>("task"); 
	public static FilterField<Activity, String> thread_id = new FilterField<>("thread_id"); 
	public static FilterField<Activity, Integer> time_allocation = new FilterField<>("time_allocation"); 
	public static FilterField<Activity, Visibility> visiblity = new FilterField<>("visiblity"); 

}