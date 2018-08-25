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

    //=======================| UsersModel/UserModel |=======================
    public final static String USERS_TABLE_NAME = "users_table";
    public final static String USERS_COLUMN1 = "full_name";
    public final static String USERS_COLUMN2 = "designation";
    public final static String USERS_COLUMN3 = "email";
    public final static String USERS_COLUMN4 = "phone_number";
    public final static String USERS_COLUMN5 = "address";
    public final static String USERS_COLUMN6 = "username";
    public final static String USERS_COLUMN7 = "password";
    public final static String USERS_COLUMN8 = "user_role";
    public final static String USERS_COLUMN9 = "photo_name";
    public final static String USERS_COLUMN10 = "photo_path";
    public final static String USERS_COLUMN11 = "created_by_id";
    public final static String USERS_COLUMN12 = "updated_by_id";
    public final static String USERS_COLUMN13 = "created_at";
    protected final static String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERS_COLUMN1 + " TEXT, " + USERS_COLUMN2 + " TEXT, " + USERS_COLUMN3 + " TEXT, " + USERS_COLUMN4 + " TEXT, " + USERS_COLUMN5 + " TEXT, " + USERS_COLUMN6 + " TEXT, " + USERS_COLUMN7 + " TEXT, " + USERS_COLUMN8 + " TEXT, " + USERS_COLUMN9 + " TEXT, " + USERS_COLUMN10 + " TEXT, " + USERS_COLUMN11 + " TEXT, " + USERS_COLUMN12 + " TEXT, " + USERS_COLUMN13 + " TEXT ) ";
    protected final static String DROP_USERS_TABLE = "DROP TABLE IF EXISTS " + USERS_TABLE_NAME + " ";
    public final static String SELECT_USERS_TABLE = "SELECT * FROM " + USERS_TABLE_NAME;

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
    public final static String LOGIN_TABLE_NAME = "login_table";
    public final static String LOGIN_COLUMN1 = "username";
    public final static String LOGIN_COLUMN2 = "password";
    public final static String LOGIN_COLUMN3 = "login_time";
    protected final static String CREATE_LOGIN_TABLE = "CREATE TABLE " + LOGIN_TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOGIN_COLUMN1 + " TEXT, " + LOGIN_COLUMN2 + " TEXT, " + LOGIN_COLUMN3 + " TEXT ) ";
    protected final static String DROP_LOGIN_TABLE = "DROP TABLE IF EXISTS " + LOGIN_TABLE_NAME + " ";
    public final static String SELECT_LOGIN_TABLE = "SELECT * FROM " + LOGIN_TABLE_NAME;
    public final static String INSERT_ADMIN_DATA = "INSERT INTO users_table (full_name,designation,email,phone_number,address,username,password,photo_name,photo_path,created_by_id, created_at) VALUES ('Admin', 'Programmer', 'mustofa2008@gmail.com', '+8801914141707', 'Dhaka Cantonment', 'admin', 'admin', 'admin', 'com.sm.demo.salesmanagement', 'created by kamal', '2018-08-26 00:05:30.729');";
}
