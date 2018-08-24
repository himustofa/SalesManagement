package com.sm.demo.salesmanagement.database;

public class ConstantKey {

    public final static String COLUMN_ID = "id";

    //=======================| SuppliersModel |=======================
    public final static String SUPPLIERS_TABLE_NAME = "suppliers_table";
    public final static String SUPPLIERS_COLUMN1 = "supplier_name";
    public final static String SUPPLIERS_COLUMN2 = "supplier_company_name";
    public final static String SUPPLIERS_COLUMN3 = "supplier_contact_person";
    public final static String SUPPLIERS_COLUMN4 = "supplier_phone_number";
    public final static String SUPPLIERS_COLUMN5 = "supplier_address";
    public final static String SUPPLIERS_COLUMN6 = "supplier_bank_name";
    public final static String SUPPLIERS_COLUMN7 = "supplier_bank_account";
    public final static String SUPPLIERS_COLUMN8 = "supplier_email";
    public final static String SUPPLIERS_COLUMN9 = "supplier_website";
    public final static String SUPPLIERS_COLUMN10 = "supplier_description";
    public final static String SUPPLIERS_COLUMN11 = "created_by_id";
    public final static String SUPPLIERS_COLUMN12 = "updated_by_id";
    public final static String SUPPLIERS_COLUMN13 = "created_at";
    protected final static String CREATE_SUPPLIERS_TABLE = "CREATE TABLE " + SUPPLIERS_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUPPLIERS_COLUMN1 + " TEXT, " + SUPPLIERS_COLUMN2 + " TEXT, " + SUPPLIERS_COLUMN3 + " TEXT, " + SUPPLIERS_COLUMN4 + " TEXT, " + SUPPLIERS_COLUMN5 + " TEXT, " + SUPPLIERS_COLUMN6 + " TEXT, " + SUPPLIERS_COLUMN7 + " TEXT, " + SUPPLIERS_COLUMN8 + " TEXT, " + SUPPLIERS_COLUMN9 + " TEXT, " + SUPPLIERS_COLUMN10 + " TEXT, " + SUPPLIERS_COLUMN11 + " TEXT, " + SUPPLIERS_COLUMN12 + " TEXT, " + SUPPLIERS_COLUMN13 + " TEXT ) ";
    protected final static String DROP_SUPPLIERS_TABLE = "DROP TABLE IF EXISTS " + SUPPLIERS_TABLE_NAME + " ";
    public final static String SELECT_SUPPLIERS_TABLE = "SELECT * FROM " + SUPPLIERS_TABLE_NAME;

    //=======================| ProductsModel |=======================
    protected final static String PRODUCTS_TABLE_NAME = "products_table";
    public final static String PRODUCTS_COLUMN1 = "product_name";
    public final static String PRODUCTS_COLUMN2 = "product_code";
    public final static String PRODUCTS_COLUMN3 = "product_quantity";
    public final static String PRODUCTS_COLUMN4 = "product_price";
    public final static String PRODUCTS_COLUMN5 = "product_expire_date";
    public final static String PRODUCTS_COLUMN6 = "product_description";
    public final static String PRODUCTS_COLUMN7 = "created_by_id";
    public final static String PRODUCTS_COLUMN8 = "updated_by_id";
    public final static String PRODUCTS_COLUMN9 = "created_at";
    protected final static String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + PRODUCTS_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PRODUCTS_COLUMN1 + " TEXT, " + PRODUCTS_COLUMN2 + " TEXT, " + PRODUCTS_COLUMN3 + " INTEGER, " + PRODUCTS_COLUMN4 + " REAL, " + PRODUCTS_COLUMN5 + " TEXT, " + PRODUCTS_COLUMN6 + " TEXT, " + PRODUCTS_COLUMN7 + " TEXT, " + PRODUCTS_COLUMN8 + " TEXT, " + PRODUCTS_COLUMN9 + " TEXT ) ";
    protected final static String DROP_PRODUCTS_TABLE = "DROP TABLE IF EXISTS " + PRODUCTS_TABLE_NAME + " ";

    //=======================| PurchasesModel |=======================
    protected final static String PURCHASES_TABLE_NAME = "purchases_table";
    public final static String PURCHASES_COLUMN1 = "product_name";
    public final static String PURCHASES_COLUMN2 = "product_id";
    public final static String PURCHASES_COLUMN3 = "supplier_name";
    public final static String PURCHASES_COLUMN4 = "supplier_id";
    public final static String PURCHASES_COLUMN5 = "purchase_product_quantity";
    public final static String PURCHASES_COLUMN6 = "purchase_product_price";
    public final static String PURCHASES_COLUMN7 = "purchase_date";
    public final static String PURCHASES_COLUMN8 = "purchase_amount";
    public final static String PURCHASES_COLUMN9 = "purchase_payment";
    public final static String PURCHASES_COLUMN10 = "purchase_balance";
    public final static String PURCHASES_COLUMN11 = "purchase_description";
    public final static String PURCHASES_COLUMN12 = "created_by_id";
    public final static String PURCHASES_COLUMN13 = "updated_by_id";
    public final static String PURCHASES_COLUMN14 = "created_at";
    protected final static String CREATE_PURCHASES_TABLE = "CREATE TABLE " + PURCHASES_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PURCHASES_COLUMN1 + " TEXT, " + PURCHASES_COLUMN2 + " TEXT, " + PURCHASES_COLUMN3 + " TEXT, " + PURCHASES_COLUMN4 + " TEXT, " + PURCHASES_COLUMN5 + " INTEGER, " + PURCHASES_COLUMN6 + " REAL, " + PURCHASES_COLUMN7 + " TEXT, " + PURCHASES_COLUMN8 + " REAL, " + PURCHASES_COLUMN9 + " REAL, " + PURCHASES_COLUMN10 + " REAL, " + PURCHASES_COLUMN11 + " TEXT, " + PURCHASES_COLUMN12 + " TEXT, " + PURCHASES_COLUMN13 + " TEXT, " + PURCHASES_COLUMN14 + " TEXT ) ";
    protected final static String DROP_PURCHASES_TABLE = "DROP TABLE IF EXISTS " + PURCHASES_TABLE_NAME + " ";

    //=======================| CustomersModel |=======================
    protected final static String CUSTOMERS_TABLE_NAME = "customers_table";
    public final static String CUSTOMERS_COLUMN1 = "customer_name";
    public final static String CUSTOMERS_COLUMN2 = "customer_phone_number";
    public final static String CUSTOMERS_COLUMN3 = "customer_email";
    public final static String CUSTOMERS_COLUMN4 = "customer_contact_person";
    public final static String CUSTOMERS_COLUMN5 = "customer_discount";
    public final static String CUSTOMERS_COLUMN6 = "customer_address";
    public final static String CUSTOMERS_COLUMN7 = "customer_description";
    public final static String CUSTOMERS_COLUMN8 = "created_by_id";
    public final static String CUSTOMERS_COLUMN9 = "updated_by_id";
    public final static String CUSTOMERS_COLUMN10 = "created_at";
    protected final static String CREATE_CUSTOMERS_TABLE = "CREATE TABLE " + CUSTOMERS_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CUSTOMERS_COLUMN1 + " TEXT, " + CUSTOMERS_COLUMN2 + " TEXT, " + CUSTOMERS_COLUMN3 + " TEXT, " + CUSTOMERS_COLUMN4 + " TEXT, " + CUSTOMERS_COLUMN5 + " REAL, " + CUSTOMERS_COLUMN6 + " TEXT, " + CUSTOMERS_COLUMN7 + " TEXT, " + CUSTOMERS_COLUMN8 + " TEXT, " + CUSTOMERS_COLUMN9 + " TEXT, " + CUSTOMERS_COLUMN10 + " TEXT ) ";
    protected final static String DROP_CUSTOMERS_TABLE = "DROP TABLE IF EXISTS " + CUSTOMERS_TABLE_NAME + " ";

    //=======================| SalesModel |=======================
    protected final static String SALES_TABLE_NAME = "sales_table";
    public static final String SALES_COLUMN1 = "product_name";
    public static final String SALES_COLUMN2 = "product_id";
    public static final String SALES_COLUMN3 = "purchase_product_quantity";
    public static final String SALES_COLUMN4 = "product_quantity";
    public static final String SALES_COLUMN5 = "customer_name";
    public static final String SALES_COLUMN6 = "customer_id";
    public static final String SALES_COLUMN7 = "sales_date";
    public static final String SALES_COLUMN8 = "sales_discount";
    public static final String SALES_COLUMN9 = "sales_vat";
    public static final String SALES_COLUMN10 = "sales_amount";
    public static final String SALES_COLUMN11 = "sales_payment";
    public static final String SALES_COLUMN12 = "sales_balance";
    public static final String SALES_COLUMN13 = "sales_description";
    public static final String SALES_COLUMN14 = "created_by_id";
    public static final String SALES_COLUMN15 = "updated_by_id";
    public static final String SALES_COLUMN16 = "created_at";
    protected final static String CREATE_SALES_TABLE = "CREATE TABLE " + SALES_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SALES_COLUMN1 + " TEXT, " + SALES_COLUMN2 + " TEXT, " + SALES_COLUMN3 + " INTEGER, " + SALES_COLUMN4 + " INTEGER, " + SALES_COLUMN5 + " TEXT, " + SALES_COLUMN6 + " TEXT, " + SALES_COLUMN7 + " TEXT, " + SALES_COLUMN8 + " REAL, " + SALES_COLUMN9 + " REAL, " + SALES_COLUMN10 + " REAL, " + SALES_COLUMN11 + " REAL, " + SALES_COLUMN12 + " REAL, " + SALES_COLUMN13 + " TEXT, " + SALES_COLUMN14 + " TEXT, " + SALES_COLUMN15 + " TEXT, " + SALES_COLUMN16 + " TEXT ) ";
    protected final static String DROP_SALES_TABLE = "DROP TABLE IF EXISTS " + SALES_TABLE_NAME + " ";

    //=======================| AdministratorModel/UserModel |=======================
    protected final static String ADMINISTRATOR_TABLE_NAME = "administrator_table";
    public final static String ADMINISTRATOR_COLUMN1 = "full_name";
    public final static String ADMINISTRATOR_COLUMN2 = "designation";
    public final static String ADMINISTRATOR_COLUMN3 = "email";
    public final static String ADMINISTRATOR_COLUMN4 = "phone_number";
    public final static String ADMINISTRATOR_COLUMN5 = "address";
    public final static String ADMINISTRATOR_COLUMN6 = "username";
    public final static String ADMINISTRATOR_COLUMN7 = "password";
    public final static String ADMINISTRATOR_COLUMN8 = "user_role";
    public final static String ADMINISTRATOR_COLUMN9 = "photo_name";
    public final static String ADMINISTRATOR_COLUMN10 = "photo_data";
    public final static String ADMINISTRATOR_COLUMN11 = "created_by_id";
    public final static String ADMINISTRATOR_COLUMN12 = "updated_by_id";
    public final static String ADMINISTRATOR_COLUMN13 = "created_at";
    protected final static String CREATE_ADMINISTRATOR_TABLE = "CREATE TABLE " + ADMINISTRATOR_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ADMINISTRATOR_COLUMN1 + " TEXT, " + ADMINISTRATOR_COLUMN2 + " TEXT, " + ADMINISTRATOR_COLUMN3 + " TEXT, " + ADMINISTRATOR_COLUMN4 + " TEXT, " + ADMINISTRATOR_COLUMN5 + " TEXT, " + ADMINISTRATOR_COLUMN6 + " TEXT, " + ADMINISTRATOR_COLUMN7 + " TEXT, " + ADMINISTRATOR_COLUMN8 + " TEXT, " + ADMINISTRATOR_COLUMN9 + " TEXT, " + ADMINISTRATOR_COLUMN10 + " TEXT, " + ADMINISTRATOR_COLUMN11 + " TEXT, " + ADMINISTRATOR_COLUMN12 + " TEXT, " + ADMINISTRATOR_COLUMN13 + " TEXT ) ";
    protected final static String DROP_ADMINISTRATOR_TABLE = "DROP TABLE IF EXISTS " + ADMINISTRATOR_TABLE_NAME + " ";

    //=======================| ProfilesModel |=======================
    public final static String PROFILES_TABLE_NAME = "profiles_table";
    public final static String PROFILES_COLUMN1 = "company_name";
    public final static String PROFILES_COLUMN2 = "company_email";
    public final static String PROFILES_COLUMN3 = "company_phone_number";
    public final static String PROFILES_COLUMN4 = "company_address";
    public final static String PROFILES_COLUMN5 = "logo_name";
    public final static String PROFILES_COLUMN6 = "logo_path";
    public final static String PROFILES_COLUMN7 = "logo_data";
    public final static String PROFILES_COLUMN8 = "time_zone";
    public final static String PROFILES_COLUMN9 = "country";
    public final static String PROFILES_COLUMN10 = "date_format";
    public final static String PROFILES_COLUMN11 = "currency_format";
    public final static String PROFILES_COLUMN12 = "created_by_id";
    public final static String PROFILES_COLUMN13 = "updated_by_id";
    public final static String PROFILES_COLUMN14 = "created_at";
    //protected final static String CREATE_PROFILES_TABLE = "CREATE TABLE " + PROFILES_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " + PROFILES_COLUMN1 + " TEXT, " + PROFILES_COLUMN2 + " TEXT, " + PROFILES_COLUMN3 + " TEXT, " + PROFILES_COLUMN4 + " TEXT, " + PROFILES_COLUMN5 + " TEXT, " + PROFILES_COLUMN6 + " TEXT, " + PROFILES_COLUMN7 + " TEXT, " + PROFILES_COLUMN8 + " TEXT, " + PROFILES_COLUMN9 + " TEXT, " + PROFILES_COLUMN10 + " TEXT, " + PROFILES_COLUMN11 + " TEXT, " + PROFILES_COLUMN12 + " TEXT, " + PROFILES_COLUMN13 + " TEXT, " + PROFILES_COLUMN14 + " TEXT ) ";
    protected final static String CREATE_PROFILES_TABLE = "CREATE TABLE " + PROFILES_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROFILES_COLUMN1 + " TEXT, " + PROFILES_COLUMN2 + " TEXT, " + PROFILES_COLUMN3 + " TEXT, " + PROFILES_COLUMN4 + " TEXT, " + PROFILES_COLUMN5 + " TEXT, " + PROFILES_COLUMN6 + " TEXT, " + PROFILES_COLUMN12 + " TEXT, " + PROFILES_COLUMN13 + " TEXT, " + PROFILES_COLUMN14 + " TEXT ) ";
    protected final static String DROP_PROFILES_TABLE = "DROP TABLE IF EXISTS " + PROFILES_TABLE_NAME + " ";
    public final static String SELECT_PROFILES_TABLE = "SELECT * FROM " + PROFILES_TABLE_NAME;


    //=======================| LoginModel |=======================
    public final static String TABLE_NAME = "MY_TABLE";
    public final static String COLUMN1 = "ID";
    public final static String COLUMN2 = "USER_NAME";
    public final static String COLUMN3 = "PASS_WORD";
    public final static String CREATE_TABLE_QUERY = "CREATE TABLE "+TABLE_NAME+" ("+COLUMN1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN2+" TEXT NOT NULL, "+COLUMN3+" TEXT NOT NULL);";
    public final static String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    public final static String SELECT_TABLE = "SELECT * FROM " + TABLE_NAME;

}
