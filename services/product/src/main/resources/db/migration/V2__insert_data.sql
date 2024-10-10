-- Insert into category table using sequence for id
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Electronic devices such as phones, laptops, and tablets', 'Electronics'),
    (nextval('category_seq'), 'Home appliances and tools', 'Home Appliances'),
    (nextval('category_seq'), 'Clothing and accessories for men and women', 'Fashion'),
    (nextval('category_seq'), 'Books of various genres', 'Books'),
    (nextval('category_seq'), 'Health and beauty products', 'Health & Beauty');




