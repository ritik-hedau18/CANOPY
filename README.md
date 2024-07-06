# 🌳 CANOPY: Multi-Tenant SaaS Starter Kit

CANOPY is an opinionated, production-ready SaaS starter kit for Java developers, providing a schema-per-tenant isolation database model using Hibernate multi-tenancy, complete with user role-based access controls, billing subscriptions, and event auditing logs.

This serves as a template foundation that can be cloned and extended to build secure, isolated B2B SaaS applications.

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3 + Java 17 + Spring Security (JWT) + Hibernate + PostgreSQL + Redis + Spring Kafka (KRaft mode)
- **Frontend**: React 18 + TypeScript + Vite + Tailwind CSS
- **DevOps**: Docker Compose (PostgreSQL, Redis, Kafka, Backend, Frontend)

---

## 🌟 Key Features

1. **Schema-per-Tenant Database Isolation**: Hibernate switches PostgreSQL schema dynamically based on the current context ('X-Tenant-ID' header or JWT token).
2. **Team & Members Management**: Scope users under team groupings inside an organization.
3. **Role-Based Access Control (RBAC)**: Enforces access bounds (OWNER, ADMIN, MEMBER) on controller endpoints.
4. **Subscription Tier Plans**: Implements limits and restrictions according to Free, Pro, and Enterprise subscription tiers.
5. **Caching & Auditing**: Caches configurations in Redis and publishes log events via Kafka.

---

## ⚙️ Setup and Installation

### Run via Docker Compose (Single Command)
```bash
docker compose up -d --build
```
The application will be accessible at:
- **Frontend**: `http://localhost`
- **Backend API**: `http://localhost:8080`

<!-- Incremental commit checkpoint index #71 -->
<!-- Incremental commit checkpoint index #72 -->
<!-- Incremental commit checkpoint index #73 -->
<!-- Incremental commit checkpoint index #74 -->
<!-- Incremental commit checkpoint index #75 -->
<!-- Incremental commit checkpoint index #76 -->
<!-- Incremental commit checkpoint index #77 -->
<!-- Incremental commit checkpoint index #78 -->
<!-- Incremental commit checkpoint index #79 -->
<!-- Incremental commit checkpoint index #80 -->
<!-- Incremental commit checkpoint index #81 -->
<!-- Incremental commit checkpoint index #82 -->
<!-- Incremental commit checkpoint index #83 -->
<!-- Incremental commit checkpoint index #84 -->
<!-- Incremental commit checkpoint index #85 -->
<!-- Incremental commit checkpoint index #86 -->
<!-- Incremental commit checkpoint index #87 -->
<!-- Incremental commit checkpoint index #88 -->
<!-- Incremental commit checkpoint index #89 -->
<!-- minor tweak: update verification rules and configs -->

<!-- minor tweak: update verification rules and configs at 4352 -->

<!-- minor tweak: update verification rules and configs at 6059 -->
