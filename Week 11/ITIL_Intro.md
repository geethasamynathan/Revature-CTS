# ITIL 

## 1) What is ITIL?
**ITIL (Information Technology Infrastructure Library)** is a set of **best practices** for managing and delivering **IT services** in a consistent, reliable, and measurable way.

ITIL helps an organization avoid “random fixing” and instead follow:
- clear processes
- defined roles
- tracking and reporting
- continuous improvement

> ITIL treats IT as a **service** (Email service, VPN service, Website service, Laptop service, etc.)

---

## 2) Who is using ITIL?
ITIL is used by **any organization that provides IT services**, especially where uptime and control are important.

### ✅ Industries / Organizations
- IT Services & Product Companies
- Banks & Finance
- Hospitals / Healthcare
- Retail & E-commerce
- Telecom
- Government
- Manufacturing (ERP/SAP environments)

### ✅ Roles (people who use ITIL practices daily)
- Service Desk / Helpdesk Engineers (L1/L2)
- System Admins / Network Admins
- IT Operations & IT Managers
- DevOps / SRE teams (incident & change practices)
- Security & Compliance teams
- Application Support teams

---

## 3) What is the Use of ITIL? (Why do companies follow it?)
### 1) Organized support (faster resolution)
Tickets are handled with a standard flow:
**Create ticket → Assign → Work → Resolve → Close**

### 2) Better uptime (less downtime)
Using **Incident + Problem management**, repeated issues reduce over time.

### 3) Safe changes (avoid production failures)
Using **Change Enablement (Change Management)**, production deployments become controlled and approved.

### 4) Accountability and reporting
IT can track:
- response time
- resolution time
- SLA compliance
- number of incidents and recurring issues

### 5) Better end-user experience
Users get predictable service and visibility through ticket updates.

---

## 4) Core ITIL Practices 

| ITIL Practice | Simple meaning | Example |
|---|---|---|
| **Incident Management** | Restore service quickly | “VPN not working” |
| **Problem Management** | Fix root cause permanently | VPN fails daily due to DNS issue |
| **Change Enablement** | Make changes safely with approvals | Deploying a new release |
| **Service Request Management** | Handle standard user requests | “Need laptop / access / software” |
| **Knowledge Management** | Store solutions (SOP/KB) | “How to reset password” article |
| **Service Level Management** | Track SLAs | P1 must be fixed in 4 hours |

---

## 5) How ITIL is Implemented
### Scenario: “Banking App Outage” (Major Incident)

**Situation:** Bank customers cannot login to the mobile app.

### ITIL flow (step-by-step)
1. **Incident ticket created**
   - Users report issue
   - Monitoring alerts trigger (errors/latency/CPU)

2. **Categorize + Prioritize**
   - Ticket becomes **P1 (Critical)**
   - SLA clock starts

3. **Assign to right teams**
   - App Support + DevOps + DB team join a “war room”

4. **Workaround to restore service**
   - Rollback deployment OR restart service OR switch traffic to standby

5. **Resolve & close incident**
   - Service restored
   - Users informed
   - Ticket closed after verification

6. **Problem Management starts**
   - Find root cause: “New release caused DB connection leak”

7. **Change Enablement**
   - Permanent fix planned
   - Approval + testing + controlled deployment

8. **Knowledge article created**
   - Document steps and solution for future incidents

**Result:**
- faster recovery
- fewer repeated issues
- safer deployments
- proper reports for leadership

---

## 6) Which Tools are used for ITIL?
ITIL is a framework, but **tools help execute ITIL processes**.

### Common ITIL / ITSM tools
- **ServiceNow ITSM**
- **Jira Service Management (JSM)**
- **BMC Helix / Remedy**
- **Freshservice**
- **ManageEngine ServiceDesk Plus**
- **Ivanti**

**What these tools provide:**
- Ticketing (Incident/Request/Problem/Change)
- Workflows & approvals
- SLA tracking
- Knowledge base (KB)
- Dashboards & reports

---

## 7) How to use an ITIL Tool 

### A) Incident Management (common steps in any tool)
1. **Create Incident**
   - Category (Network/Email/App)
   - Description + error message
   - Attach screenshot (optional)

2. **Set Priority**
   - P1: Business down (critical)
   - P2: Major impact
   - P3: Normal issue
   - P4: Low impact

3. **Assign to Group**
   - Network Team / App Support / Desktop Support

4. **Work Notes + Resolution**
   - Add investigation steps
   - Add fix details

5. **Close**
   - User confirms fix
   - Ticket closed
   - Feedback captured

---

### B) Service Request (Access / Laptop / Software)
1. User selects a **catalog item**
2. Tool sends request to **approver**
3. After approval, a task goes to IT team
4. Completed → delivered → closed

---

### C) Change Enablement (safe deployment)
1. Create change request (Standard/Normal/Emergency)
2. Add risk + implementation plan + rollback plan
3. Get approvals (Manager/CAB)
4. Implement in planned window
5. Post-implementation review and close

---

## 8) Example: How to do this in ServiceNow 
### 1) Raise an Incident
- Go to **Incident → Create New**
- Fill:
  - Caller (user name)
  - Short description (1 line)
  - Description (steps + error)
  - Category/Subcategory
  - Impact + Urgency (priority auto-calculates)
- Click **Submit**

### 2) Support Engineer handles it
- Open incident
- Check SLA timer and assignment group
- Add work notes
- State: **New → In Progress → Resolved → Closed**

### 3) Create a Problem (for recurring issues)
- From incident: **Create Problem**
- Add RCA details
- Link related incidents
- Add permanent fix tasks

### 4) Create a Change (for permanent fix deployment)
- Change → New
- Add plan, risk, rollback, test evidence
- Approvals → Implement → Close

---

## 9) Example: How to do this in Jira Service Management 
### 1) User raises request
- Portal → select “Report an Incident”
- Fill form → Submit

### 2) Agent handles the ticket
- Open from queue
- Set priority + SLA
- Assign to self/team
- Add internal notes + user comments
- Resolve → close

### 3) Knowledge base
- Create KB article (often via Confluence integration)

---

## 10) Quick Summary (easy memory)
- **ITIL = Best practices to manage IT services**
- **Tools = ServiceNow / Jira Service Management / Freshservice** to run those processes
- **Goal = Faster support, fewer incidents, safer changes, measurable performance**
