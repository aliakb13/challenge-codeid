CREATE SCHEMA IF NOT EXISTS oe;

DROP TABLE IF EXISTS oe.order_details;
DROP TABLE IF EXISTS oe.orders;
DROP TABLE IF EXISTS oe.products;
DROP TABLE IF EXISTS oe.shippers;
DROP TABLE IF EXISTS oe.suppliers;
DROP TABLE IF EXISTS oe.categories;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.categories (
    category_id serial NOT NULL primary key,
    category_name varchar(15) NOT NULL,
    description text,
    picture bytea,
    created_date  timestamp default current_timestamp,
    modified_date timestamp
);

--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.suppliers (
    supplier_id serial NOT NULL primary key,
    company_name varchar(40) NOT NULL,
    created_date  timestamp default current_timestamp,
    modified_date timestamp
);

--
-- Name: products; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.products (
    product_id serial NOT NULL primary key,
    product_name varchar(40) NOT NULL,
    supplier_id integer,
    category_id integer,
    quantity_per_unit varchar(20),
    unit_price real,
    units_in_stock smallint,
    units_on_order smallint,
    reorder_level smallint,
    discontinued integer NOT NULL,
    created_date  timestamp default current_timestamp,
    modified_date timestamp,
    constraint fk_supplier_id foreign key (supplier_id) references oe.suppliers(supplier_id) on delete cascade,
    constraint fk_category_id foreign key (category_id) references oe.categories(category_id) on delete cascade
);

--
-- Name: orders; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE IF NOT EXISTS oe.orders
(
    order_id varchar(75) NOT NULL,
    order_no varchar(15),
    order_date date,
    required_date date,
    shipped_date date,
    ship_via smallint,
    freight decimal(5,2),
    ship_name varchar(40),
    total_discount decimal(5,2),
    total_amount decimal(8,2),
    payment_type varchar(15),
    card_no varchar(25),
    transac_no varchar(25),
    transac_date timestamp without time zone,
    ref_no varchar(25),
    user_id integer,
	  created_date  timestamp default current_timestamp,
    modified_date timestamp,
    CONSTRAINT pk_orders PRIMARY KEY (order_id),
    CONSTRAINT fk_orders_users FOREIGN KEY (user_id) REFERENCES person.users (user_id) on delete cascade,
    CONSTRAINT orders_payment_type_check CHECK (payment_type::text = ANY (ARRAY['DEBIT'::varchar::text, 'CREDIT'::varchar::text, 'QRIS'::varchar::text, 'TRANSFER'::varchar::text]))
);

--
-- Name: order_details; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.order_details (
    order_id varchar(75) NOT NULL,
    product_id integer NOT NULL,
    unit_price real NOT NULL,
    quantity smallint NOT NULL,
    discount real NOT NULL,
    constraint pk_order_details primary key(order_id, product_id),
    constraint fk_order_id foreign key (order_id) references oe.orders(order_id) on delete cascade,
    constraint fk_product_id foreign key (product_id) references oe.products(product_id) on delete cascade
);