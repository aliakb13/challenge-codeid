-- force delete
drop sequence if exists oe.products_product_id_seq cascade;
alter table oe.products drop column photo; 

-- add column pada products untuk photo (Text)
alter table oe.products add column photo text;

-- Buat sequence untuk id products atau generate dari uuid -> kalo generate uuid alter table ke varchar
create sequence if not exists oe.products_product_id_seq start 1;

alter table oe.products alter column product_id set default nextval('oe.products_product_id_seq');
alter table oe.products alter column product_id set not null;