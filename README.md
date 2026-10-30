# EduMind: Student Self-Evaluation and Early-Warning System

Summer internship project (2025).

EduMind is a Spring Boot backend that helps teachers notice students who may be struggling. Students submit short self-evaluations; each one is classified by sentiment with the Baidu NLP API, and a student is flagged when two consecutive submissions are negative. Teachers can review the flagged list and each student's sentiment trend, plotted with ECharts.

## Features
- Self-evaluation submission with input validation
- Sentiment classification (positive / neutral / negative, with confidence) via Baidu NLP
- Early warning when two consecutive evaluations are negative
- Per-student history and sentiment trend chart
- Bulk import of student rosters from Excel (EasyExcel)

## API
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/evaluation/submit` | Submit a self-evaluation |
| `GET` | `/api/evaluation/recent/{studentId}` | Most recent evaluations |
| `GET` | `/api/evaluation/all/{studentId}` | Full history |
| `GET` | `/api/evaluation/trend/{studentId}` | Sentiment trend points |
| `GET` | `/api/evaluation/warnings` | Students currently flagged |
| `GET` | `/api/student/{id}` · `/api/student/all` | Student records |
| `POST` | `/api/student/import` | Import students from Excel |

## Running
Requires JDK 8+, Maven, and MySQL.
```bash
export DB_USERNAME=root
export DB_PASSWORD=your-mysql-password
export BAIDU_APP_ID=...  BAIDU_API_KEY=...  BAIDU_SECRET_KEY=...
mvn spring-boot:run
```
Create a MySQL database named `edumind` first. The server starts on port 8080, and the trend chart page is at `src/main/java/com/edumind/ui/index.html`.

## Tech stack
Spring Boot 2.7 · MyBatis · MySQL · Baidu AI NLP SDK · EasyExcel · ECharts

## Next steps
- Email alerts to teachers (Spring Mail)
- Replace the external API with a fine-tuned sentiment classifier
- OpenAPI documentation

## License
MIT
