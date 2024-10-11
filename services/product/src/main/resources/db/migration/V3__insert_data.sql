-- Inserting products with correct category_id values
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'High performance smartphone with 128GB storage', 'Smartphone', 50, 699.99, 1),  -- Electronics
    (nextval('product_seq'), 'Ultra-thin laptop with Intel i7 processor and 16GB RAM', 'Laptop', 30, 1199.99, 1), -- Electronics
    (nextval('product_seq'), 'Stainless steel blender with 700W motor', 'Blender', 40, 49.99, 51),              -- Home Appliances
    (nextval('product_seq'), 'Ergonomic office chair with lumbar support', 'Office Chair', 25, 149.99, 51),     -- Home Appliances
    (nextval('product_seq'), 'Men\''s casual t-shirt made of organic cotton', 'Men\''s T-shirt', 100, 19.99, 1),  -- Fashion
    (nextval('product_seq'), 'Women\''s denim jacket with a relaxed fit', 'Women\''s Denim Jacket', 60, 49.99, 101), -- Fashion
    (nextval('product_seq'), 'Best-selling science fiction novel', 'Science Fiction Book', 150, 14.99, 151),     -- Books
    (nextval('product_seq'), 'Skincare cream for all skin types', 'Skincare Cream', 200, 29.99, 201);            -- Health & Beauty



INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    -- Electronics (category_id: 1001)
    (nextval('product_seq'), 'Wireless noise-cancelling headphones with 30 hours battery life', 'Headphones', 75, 199.99, 1),
    (nextval('product_seq'), '4K UHD Smart TV with HDR support', 'Smart TV', 40, 899.99, 1),

    -- Home Appliances (category_id: 1051)
    (nextval('product_seq'), 'Cordless vacuum cleaner with HEPA filter', 'Vacuum Cleaner', 60, 249.99, 51),
    (nextval('product_seq'), 'Energy-efficient washing machine with 7kg capacity', 'Washing Machine', 25, 599.99, 51),
    (nextval('product_seq'), 'Multi-function air fryer with digital controls', 'Air Fryer', 80, 129.99, 51),

    -- Fashion (category_id: 1101)
    (nextval('product_seq'), 'Leather ankle boots for men', 'Men\''s Leather Boots', 50, 89.99, 101),
    (nextval('product_seq'), 'Women\''s summer dress with floral pattern', 'Women\''s Summer Dress', 120, 39.99, 101),
    (nextval('product_seq'), 'Classic wristwatch with leather strap', 'Wristwatch', 90, 199.99, 101),

    -- Books (category_id: 1151)
    (nextval('product_seq'), 'Best-selling cookbook with over 200 recipes', 'Cookbook', 150, 24.99, 151),
    (nextval('product_seq'), 'Historical fiction novel set in World War II', 'Historical Fiction Novel', 100, 18.99, 151),

    -- Health & Beauty (category_id: 1201)
    (nextval('product_seq'), 'Vitamin C serum for skin rejuvenation', 'Vitamin C Serum', 250, 34.99, 201),
    (nextval('product_seq'), 'Anti-aging night cream with retinol', 'Night Cream', 200, 49.99, 201),
    (nextval('product_seq'), 'Organic shampoo for hair strengthening', 'Organic Shampoo', 180, 14.99, 201);
