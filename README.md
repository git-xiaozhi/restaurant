# 餐馆点餐系统 (前后端分离)

结构：
- backend/  — Spring Boot 后端 (端口 8080，SQLite)
- frontend/ — Vue 3 + Vite 前端 (开发服务器端口 3000)

运行后端：
1. 进入 backend 目录
2. mvn clean package
3. java -jar target/restaurant-backend-0.0.1-SNAPSHOT.jar
   （或在 IDE 中以 Spring Boot 启动）
SQLite 数据库文件会在 backend/data/restaurant.db

运行前端（开发）：
1. 进入 frontend 目录
2. npm install
3. npm run dev
访问 http://localhost:3000 （H5 页面为移动端；/admin 为简易后台）

注意：
- 后端默认允许跨域（用于本地开发）
- 若要部署到服务器或生产环境，请做如下改进：
  - 增加身份认证（例如 Spring Security / JWT）
  - 更完善的错误处理、参数校验与事务控制
  - 上传/保存图片、文件存储或 CDN
  - sqlite 可更换为 MySQL/Postgres 以便横向扩展

如何把代码推送到你的 GitHub 仓库（在本地执行）：
假设你已在本地创建了项目文件，并在仓库根目录执行：
1. git init
2. git add .
3. git commit -m "initial commit: restaurant frontend & backend"
4. git branch -M main
5. git remote add origin https://github.com/git-xiaozhi/restaurant.git
6. git push -u origin main

如果使用 HTTPS 推送，你需要提供 GitHub 账号凭据或个人访问令牌 (PAT)。也可使用 SSH remote（推荐长期使用）。