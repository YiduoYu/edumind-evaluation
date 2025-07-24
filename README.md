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

##  下一步目标

### 技术开发方向

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

## 开发环境

- JDK: 1.8（Amazon Corretto）
- Spring Boot: 2.7
- MySQL: 9.3.0
- MyBatis: 2.2
- Apifox（API 测试工具）
- IDE: IntelliJ IDEA

---

## 备注
后续扩展为心理测评系统，集成多维情绪标签与学业成绩联动分析。
