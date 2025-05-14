-- add column pada products untuk photo (Text)
alter table oe.products add column photo text;

-- Buat sequence untuk id products atau generate dari uuid -> kalo generate uuid alter table ke varchar


-- Buat foreign key untuk kolom supplier_id dan category_id
alter table oe.products add constraint fk_supplier foreign key (supplier_id) references oe.suppliers(supplier_id) on delete cascade;
alter table oe.products add constraint fk_category foreign key (category_id) references oe.categories(category_id) on delete cascade;
