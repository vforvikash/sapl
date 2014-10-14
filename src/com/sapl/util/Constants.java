package com.sapl.util;

public class Constants {
	
	/**
	 * variable Sets the record status as deleted
	 */
	public static final String DELETED="Y";
	/**
	 * variable Sets the record status as not deleted
	 */
	public static final String NOT_DELETED="N";
	/**
	 * variable Sets the custom tree type
	 */
	public static final String CUSTOM_TREETYPE="CUSTOM";
	/**
	 * variable used to display the tree Node
	 */
	public static final String SHOW="show";
	/**
	 * variable used to hide the tree Node
	 */
	public static final String HIDE="hide";
	
	/**
	 * variable used to move up the tree node
	 */
	public static final String UP ="up";
	
	/**
	 * variable used to move down the tree node
	 */
	public static final String DOWN ="down";
	
	/**
	 * variable used to insert a leaf
	 */
	public static final String INSERT ="insert";
	
	/**
	 * variable used to update the leaf
	 */
	public static final String UPDATE ="update";
	
	/**
	 *VARIABLE FOR NOTICEBOARD STATUS - IN MESSAGESUSERS_TBL 
	 */
	public static final String NOTICE ="NOTICE";
	
	/**
	 * variable used for naming convention of lesson while uploading 
	 */
	public static final String CUSTOM_LESSON="CUST_LES_";
	
	/**
	 * variable to declare file path of the lessons uploaded
	 */
	public static final String CUSTOM_LESSON_FILEPATH="../../UploadedFiles/Lessons/";
	
	/**
	 * variable to declare file path for lessons given by www.sapl.net
	 */
	public static final String SAPL_LESSON_FILEPATH="../../WebLessons/Lessons/";
	
	/**
	 * variable used for naming convention of file while uploading
	 */
	public static final String CUSTOM_FILE="CUST_FILE_";
	
	/**
	 * variable to declare file path of the files uploaded
	 */
	public static final String CUSTOM_FILE_FILEPATH="../../UploadedFiles/Files/";	
	
	/**
	 * variable user to give status=new 
	 */
	public static final String NEW_STATUS="NEW";
	public static final String READ_STATUS="READ";
	
	public static final String REGISTERED_STATUS="REGISTERED";
	
	/**
	 * variable user to give message status=INBOX 
	 */
	public static final String INBOX="INBOX";
	
	/**
	 * variable user to give message status=SENT
	 */
	public static final String SENT="SENT";
	/**
	 * variable user to give message status=PURGE
	 */
	public static final String PURGE="PURGE";
	
	/**
	 * variable user to give message(NOTICE) status=NOTICE_PURGE
	 */
	public static final String NOTICE_PURGE="NOTICEDEL";
	
	/**
	 * variable user to give message status=DELETE
	 */
	public static final String DELETE="DELETE";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF SAPL! ADMIN
	 */
	public static final String ROLE_ADMIN="ROLE_ADMIN";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF STUDENT IN SAPL!
	 */
	public static final String ROLE_STUDENT="ROLE_STUDENT";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF TEACHER IN SAPL!
	 */
	public static final String ROLE_TEACHER="ROLE_TEACHER";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF SCHOOLADMIN IN SAPL!
	 */
	public static final String ROLE_SCHOOLADMIN="ROLE_SCHOOLADMIN";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF DISTRICTADMIN IN SAPL!
	 */
	public static final String ROLE_DISTRICTADMIN="ROLE_DISTRICTADMIN";
	
	/**
	 * VARIABLE DEFINED FOR THE ROLE OF SALES PERSON IN SAPL!
	 */
	public static final String ROLE_SALES="ROLE_SALES";
	
	/**
	 * for no
	 */
	public static final String NO="N";
	
	/**
	 * for yes
	 */
	public static final String YES="Y";
	
	/**
	 * Heymath Support mail Id for sending mail 
	 */
	public static final String SAPL_SUPPORT_MAILID = "support@sapl.com<support@sapl.com>";
	
	public static final String HYEMATH_SUPPORT_FOR_MESSAGES = "HeyMath! Support";
	
	/**
	 * Account Type = Trail
	 */
	public static final String PAYMENT_TYPE_TRIAL = "TRIAL";
	
	/**
	 * Account Type = Paid
	 */
	public static final String PAYMENT_TYPE_PAID = "PAID";
	
	public static final String SCHOOL_RETAIL = "Retail";
	
	public static final String ACCOUNTTYPE_SCHOOL = "School";

	public static final String ACCOUNTTYPE_DISTRICT = "District";
	
	public static final int TCHR_CONST_TRAIL_DAYS = 44;
	
	public static final int STU_CONST_TRAIL_DAYS = 14;
	
	//for Authorization...
	
	public static final String LITE = "LITE";
	
	public static final String LESSN = "LESSN";
	
	public static final String LEAS = "LEAS";
	
	public static final String ASSIN = "ASSIN";
	
	public static final String AAT = "AAT";
	
	public static final String LETXB = "LETXB";
	
	public static final String CAL = "CALENDER";
	
	public static final String SUR = "SURVEY";
	
	public static final String PUZ = "PUZZLE";
	
	public static final String MAIL_FROM_SUPPORTDESK = "Support Desk<support@sapl.com>";
	
	public static final String SAPL_EVAL_USER = "eval";
	
	public static final String MAIL_DUMMY = "nomail@sapl.com";
	
	//VELOCITY TEMPLATE FILE PATH
	public static final String VM_TEMPLATE_PATH = "com/sapl/vmproperties/";
}
