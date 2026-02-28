# ServiceNow 

## 1) Introduction to ServiceNow
**ServiceNow** is a **cloud-based IT Service Management (ITSM)** and **enterprise workflow** platform.

### Simple definition 
ServiceNow helps organizations **manage work as tickets and workflows**, so that requests, issues, approvals, and changes are:
- tracked
- assigned
- resolved
- audited
- reported

### Why companies use ServiceNow
Without a tool, IT support becomes:
- calls/WhatsApp messages
- no tracking
- no SLA
- no visibility

With ServiceNow:
- everything becomes a **ticket**
- work is assigned to the right team
- SLAs are monitored
- dashboards show performance

### Key concept: “Platform + Workflows”
ServiceNow is not only for IT support. It is a **platform** where different departments can build workflows:
- IT
- HR
- Finance
- Facilities
- Security
- Customer support

---

## 2) What can we do using ServiceNow?
ServiceNow can manage many business workflows. Common things include:

### A) Ticketing (the most common)
- **Incidents** (service is broken): “VPN not working”
- **Service Requests** (need something): “Need a new laptop”
- **Problems** (root cause): “VPN fails every morning”
- **Changes** (safe deployments): “Deploy new app version”

### B) Service Catalog (request forms)
Users choose from a catalog:
- software installation request
- access request (VPN/Jira/Email)
- new employee onboarding
- password reset (if not automated)

### C) Approvals and workflows
- manager approval for VPN access
- security approval for admin access
- finance approval for purchase

### D) Asset & Configuration tracking
- track laptops, servers, printers
- track software licenses
- track relationships using CMDB (Configuration Management Database)

### E) Knowledge Base (KB)
- store solutions and SOPs
- reduce repeated incidents
- empower L1 service desk

### F) Monitoring and alerts (integrations)
- create incidents automatically from monitoring alerts (optional)

### G) Reporting and dashboards
- SLA compliance reports
- incident trends
- team workload
- resolution times

### H) Extend beyond IT (enterprise workflows)
- HR Case Management (employee requests)
- Customer Service Management (customer tickets)
- Security Operations (alerts → cases)

---

## 3) Architecture of ServiceNow (Simple Explanation)
ServiceNow is a **cloud SaaS platform**. You access it through a browser.

### A) High-level architecture
1. **User Interface (UI)**
   - Web browser / ServiceNow portal
   - Mobile app (optional)

2. **Application Layer**
   - Forms, workflows, business rules, scripts
   - ServiceNow apps/modules (ITSM, CMDB, etc.)

3. **Database Layer**
   - Tables that store records (incident, user, request, change…)
   - ServiceNow uses a relational database underneath, but users interact through the platform.

4. **Integration Layer**
   - Connects to other systems:
     - Email
     - Active Directory / Azure AD (SSO)
     - Monitoring tools
     - CI/CD tools
     - HR systems, etc.

### B) Instance concept 
Every customer gets a **ServiceNow Instance** (your own environment), like:
- DEV instance (for development)
- TEST instance (for testing)
- PROD instance (live)

Instance URL example format:
- https://<company>.service-now.com

### C) Key platform components 
- **Tables**: store data (incident table, user table)
- **Forms**: UI to create/update records
- **Lists**: view records in table format
- **Workflow / Flow Designer**: automate steps and approvals
- **Business Rules**: server-side logic (run on insert/update)
- **Client Scripts**: browser-side validation/UI logic
- **UI Policies**: show/hide/mandatory fields (no coding)
- **ACL (Access Controls)**: who can see/edit what
- **Notifications**: email/SMS alerts based on events

### Simple architecture diagram
```text
Users (Portal/Agent UI)
        |
        v
ServiceNow Instance (Cloud)
  - Apps/Modules (ITSM, CMDB, HR, etc.)
  - Workflows/Rules (Flow, BR, Scripts)
  - Database (Tables/Records)
        |
        v
Integrations (Email, AD/SSO, Monitoring, DevOps tools, etc.)
```

---

## 4) ServiceNow Modules and Applications (What you see in the left navigator)
In ServiceNow, you will often see:
- **Application**: a bigger category (e.g., Incident, Change, CMDB)
- **Module**: a specific menu item inside an application (e.g., “Create New”, “Open”, “All”)

### Common ServiceNow Applications (examples)
- **Incident**
  - Create New
  - Open
  - All

- **Service Catalog**
  - Order Something
  - My Requests
  - Request Approvals

- **Change**
  - Create New
  - Open
  - Change Calendar

- **Problem**
  - Create New
  - Open

- **CMDB**
  - Servers
  - Network Devices
  - Applications
  - Relationships

- **Knowledge**
  - Create Article
  - Published Articles

- **Reports**
  - Create Report
  - View Dashboards

---

## 5) ServiceNow Administration 
ServiceNow Admin is responsible for:
- users, roles, groups
- access control
- configuring forms and workflows
- maintaining data quality
- managing updates and releases

### Key admin tasks
#### A) User and Access Management
- Create users
- Create groups (Service Desk, Network Team, App Support)
- Assign roles (itil, admin, catalog_admin, report_admin etc.)
- Configure ACLs (security)

#### B) Form and Field Configuration
- Add/remove fields
- Make fields mandatory
- Change form layout
- UI Policies for no-code behavior

#### C) Workflow / Automation
- Flow Designer: approvals and tasks
- Business Rules: automation on record changes
- Notifications: email updates

#### D) Service Catalog Management
- Build catalog items (VPN request, Laptop request)
- Add approval rules
- Create fulfillment tasks

#### E) CMDB Administration
- Define CI classes (servers, apps)
- Maintain CI data accuracy
- Configure relationships and ownership

#### F) Instance Maintenance
- Manage DEV/TEST/PROD lifecycle
- Move changes using Update Sets
- Monitor performance and logs

---

## 6) ServiceNow ITSM 
**ITSM** = IT Service Management. ServiceNow ITSM is the suite that supports core ITIL practices.

### Core ITSM processes in ServiceNow
#### 1) Incident Management
**Goal:** restore service quickly  
Example: “UPI payments failing”, “VPN down”, “Email not working”

Typical states:
- New → In Progress → On Hold → Resolved → Closed

#### 2) Problem Management
**Goal:** fix root cause permanently  
Example: “VPN outage happens daily due to DNS misconfiguration”

Key activities:
- Identify recurring incidents
- Root cause analysis (RCA)
- Create permanent fix plan

#### 3) Change Enablement (Change Management)
**Goal:** introduce changes safely  
Example: “Deploy new release on Saturday 10 PM”

Key parts:
- Risk level
- Approvals (CAB/Manager)
- Implementation plan
- Rollback plan

#### 4) Request Fulfillment (Service Requests)
**Goal:** deliver standard requests through catalog  
Example:
- “New laptop request”
- “VPN access request”
- “Software install request”

#### 5) Knowledge Management
**Goal:** store solutions to reduce tickets  
Example: “How to fix ‘VPN authentication failed’”

#### 6) Service Level Management
**Goal:** define and track SLAs  
Example:
- P1 incident must be responded within 15 minutes
- resolved within 1 hour

---

## 7) Real-world Example (End-to-End) — “New Employee Onboarding”
### Need
HR wants new employee ready on Day 1 with:
- Laptop + email + VPN + project access

### How ServiceNow helps
1. HR submits **Service Catalog** request: “Employee Onboarding”
2. Auto approvals triggered (Manager/Security)
3. System creates tasks:
   - Desktop Team: Laptop
   - IAM Team: Email/VPN
   - App Admin: Jira/GitHub
4. SLA ensures completion before Day 1 morning
5. Ticket closes after employee confirmation
6. Dashboard shows completion time and bottlenecks

✅ Output:
- faster onboarding
- clear accountability
- audit trail
- better employee experience

---

## Quick 
- **ServiceNow** is a cloud platform to manage **tickets + workflows**.
- You can do **Incident, Request, Change, Problem, Knowledge, SLA, CMDB, Reports**.
- Architecture: **UI → Apps/Workflows → Database tables → Integrations**, inside a cloud **instance**.
- Admin work: **users/roles, forms, flows, catalog, CMDB, update sets**.
- ITSM is where freshers usually start (Service Desk / Support roles).
