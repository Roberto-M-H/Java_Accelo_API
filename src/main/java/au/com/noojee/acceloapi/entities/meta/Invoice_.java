package au.com.noojee.acceloapi.entities.meta;

import java.time.LocalDate;

import au.com.noojee.acceloapi.entities.Invoice;
/** 
 *
 *          DO NOT MODIFY 
 *
 * This code is generated by au.com.noojee.acceloapi.entities.generator.FieldMetaDataGenerator
 *
 * The generator use @AcceloField annotations to determine what fields to include in the Meta data.
 *
 *          DO NOT MODIFY 
 *
 */
import au.com.noojee.acceloapi.entities.meta.fieldTypes.FilterField;


public class Invoice_ 
{

	public static FilterField<Invoice, LocalDate> date_due = new FilterField<>("date_due"); 
	public static FilterField<Invoice, LocalDate> date_modified = new FilterField<>("date_modified"); 
	public static FilterField<Invoice, LocalDate> date_raised = new FilterField<>("date_raised"); 
	public static FilterField<Invoice, Integer> id = new FilterField<>("id"); 
	public static FilterField<Invoice, Integer> invoice_number = new FilterField<>("invoice_number"); 

}
