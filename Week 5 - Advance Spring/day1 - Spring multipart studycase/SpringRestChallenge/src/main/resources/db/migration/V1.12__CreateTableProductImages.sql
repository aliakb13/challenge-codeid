-- set primary key oe.products
alter table oe.products add primary key (product_id);

drop table if exists oe.product_images;

create table oe.product_images(
  image_id varchar(50) primary key,
  file_name text not null,
  file_size integer,
  file_type varchar(30),
  file_uri varchar(50),
  product_id integer not null,
  constraint fk_product_id foreign key(product_id) references oe.products(product_id) on delete cascade
);

alter table oe.products drop column photo;