# EduMind 学生心理自我评价系统

EduMind 是一个基于 Spring Boot 构建的后端服务系统，旨在通过学生提交的自我评价内容，结合 AI 情感分析与心理学模型，辅助教师及时发现学生可能存在的心理健康问题。

---

## 核心功能

-  学生自我评价提交接口
-  NLP 情绪分析（待集成）
-  自动预警系统：若学生连续两次提交负面情绪，将标记为预警，通知教师
-  教师端查看学生评价与历史数据
-  MySQL 数据库存储结构清晰，支持按学生ID检索记录

---

##  当前进度（截至 2025/07/22）

- [x] 项目基础框架构建完成（Spring Boot）
- [x] 接口开发：
  - [x] `/api/evaluation/submit` 学生提交评价
  - [x] `/api/evaluation/recent/{studentId}` 查看学生近期评价
  - [x] `/api/student/all` 教师端查看全部学生
- [x] MyBatis 接入数据库，支持查询与插入
- [x] 数据库建表成功，支持外键关联（`student_id`）
- [x] 使用 Apifox 成功调用接口并写入数据库
- [ ] AI 情绪分析模块尚未启用（占位已留）

---

## 🧭 下一步目标

### ✅ 技术开发方向

1. **集成 AI 情感分析模块**（例如百度 NLP / ChatGPT 接口）：
   - 根据 `evaluation.content` 生成 `sentiment`（positive/negative）+ `sentimentScore`
   - 触发 `warningTriggered` 标志逻辑

2. **完善预警机制**：
   - 邮件通知教师（可用 Spring Mail 实现）
   - 在教师界面添加“预警学生列表”接口

3. **完善前端或 API 文档说明**：
   - 添加 Swagger 文档或 Postman / Apifox 在线文档
   - 若需展示，可开发一个轻量级前端（可用 Vue3）

---

## 🧑‍💻 开发环境

- JDK 1.8（Amazon Corretto）
- Spring Boot 2.5+
- MySQL 8.x
- MyBatis 3.x
- Apifox（API 测试工具）
- IDE: IntelliJ IDEA

---

## 📢 备注

该项目为个人实习与科研项目的一部分，欢迎后续扩展为心理测评系统，集成多维情绪标签与学业成绩联动分析。
