CREATE TABLE IF NOT EXISTS oe.carts
(
    cart_id varchar(75) NOT NULL,
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    user_id integer,
    created_date  timestamp default current_timestamp,
    modified_date timestamp,
    CONSTRAINT pk_carts PRIMARY KEY (cart_id),
    CONSTRAINT uq_carts_user UNIQUE (user_id),
    constraint fk_user_id foreign key (user_id) references person.users(user_id)
);


CREATE TABLE IF NOT EXISTS oe.cart_items
(
    cart_id varchar(75) NOT NULL,
    product_id integer NOT NULL,
    quantity smallint,
    unit_price real,
    discount decimal(2,2),
	created_date  timestamp default current_timestamp,
    modified_date timestamp,
    CONSTRAINT pk_cart_items PRIMARY KEY (cart_id, product_id),
    CONSTRAINT fk_cart_cart_items FOREIGN KEY (cart_id) REFERENCES oe.carts (cart_id) on delete cascade
);