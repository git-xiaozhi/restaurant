-- 菜品表
CREATE TABLE IF NOT EXISTS dishes (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  description TEXT,
  price REAL NOT NULL,
  image_url TEXT,
  available INTEGER NOT NULL DEFAULT 1
);

-- 订单表（简单实现：含 JSON 字段保存项）
CREATE TABLE IF NOT EXISTS orders (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  customer_name TEXT,
  total REAL,
  items_json TEXT,
  created_at TEXT DEFAULT CURRENT_TIMESTAMP
);

-- 初始示例数据
INSERT INTO dishes (name, description, price, image_url, available) VALUES
  ('宫保鸡丁', '微辣，经典川菜', 28.0, '', 1),
  ('鱼香肉丝', '带甜辣味', 26.0, '', 1),
  ('番茄炒蛋', '家常菜，适合儿童', 18.0, '', 1);