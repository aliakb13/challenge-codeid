-- set constraint table categories
alter table oe.categories add primary key(category_id);

-- set constraint table suppliers
alter table oe.suppliers add primary key(supplier_id);

-- Buat foreign key untuk kolom supplier_id dan category_id
alter table oe.products add constraint fk_supplier foreign key (supplier_id) references oe.suppliers(supplier_id) on delete cascade;
alter table oe.products add constraint fk_category foreign key (category_id) references oe.categories(category_id) on delete cascade;