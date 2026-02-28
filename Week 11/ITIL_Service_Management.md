# Service Management in ITIL 

## 1) What is Service Management in ITIL?
**Service Management** in ITIL means **planning, delivering, operating, and improving IT services** so that business users get reliable support.

In simple words:
> **Service Management = Managing IT like a “service to customers” (employees/users), not just fixing computers.**

A “service” can be:
- Email service
- Internet/VPN service
- Application service (Payroll, HRMS, Banking app)
- Laptop/Desktop service
- Database service
- Cloud hosting service

---

## 2) Why do we need Service Management?
Without service management, IT becomes:
- “Call someone and wait”
- No tracking
- No priorities
- No SLA (time commitment)
- Same issues repeat again and again

With ITIL Service Management, you get:
- **Ticket-based tracking**
- **Priority and SLA**
- **Clear ownership (who handles what)**
- **Root cause removal**
- **Continuous improvements**

---

## 3) Real-world Example — “New Employee Onboarding”

### Business requirement
A new employee joins a company. On Day 1 they need:
- Laptop
- Email access
- VPN access
- Jira/ServiceNow access
- GitHub access
- Project folder access

### How Service Management works (ITIL way)
This is implemented using **Service Request Management** and a workflow in an ITSM tool.

#### Step-by-step flow
1. **HR raises a Service Request** (Onboarding request form)
   - Employee name, DOJ, role, department
   - Required access list

2. **Tool creates tasks automatically**
   - Task 1: Desktop team → Laptop allocation
   - Task 2: IAM team → Email + VPN user creation
   - Task 3: App Admin team → Jira/GitHub access
   - Task 4: Security team → Mandatory security policy acceptance

3. **Approvals**
   - Manager approval for VPN or sensitive systems

4. **SLA tracking**
   - Example SLA: “Onboarding must be completed before Day 1, 10 AM”

5. **Completion + closure**
   - Employee confirms access is working
   - Request is closed
   - Record is stored for audit

✅ Result: Smooth onboarding, no confusion, everything tracked.

---

## 4) How to Implement Service Management in a Company 

### Step 1: Identify key IT services
Example:
- Email Service
- Network/VPN Service
- App Support Service
- Laptop/Asset Service

### Step 2: Create a Service Catalog (request forms)
Create standard requests like:
- “New laptop request”
- “VPN access request”
- “Reset password request”
- “New employee onboarding”

### Step 3: Define processes (ITIL practices)
Most companies start with:
- **Incident Management** (service down/issues)
- **Service Request Management** (standard requests)
- **Change Enablement** (safe changes)
- **Problem Management** (permanent root cause fix)
- **Knowledge Management** (KB articles)

### Step 4: Configure an ITSM tool
Tools commonly used:
- ServiceNow ITSM
- Jira Service Management
- Freshservice
- ManageEngine ServiceDesk Plus

Configure:
- Ticket forms
- Assignment groups
- Workflows and approvals
- SLAs
- Notifications
- Dashboards

### Step 5: Train teams and go live
- Train Service Desk + Support teams
- Create KB articles
- Start running the service

---

## 5) Who will implement Service Management?

### ✅ Key roles involved
1. **IT Service Owner**
   - Owns the service (Email service owner, Network service owner)
   - Defines service quality, availability, KPIs

2. **ITSM Process Owner**
   - Designs processes like Incident, Change, Problem
   - Ensures processes follow ITIL best practices

3. **ITSM Tool Admin (ServiceNow/JSM Admin)**
   - Configures the tool: workflows, forms, SLAs, approvals

4. **Service Desk (L1)**
   - First point of contact
   - Creates/triages tickets, does basic troubleshooting

5. **Support Teams (L2/L3)**
   - Network, Server, DB, App Support, Security
   - Fix complex issues and complete request tasks

6. **Management / CAB (Change Advisory Board)**
   - Approves risky changes
   - Ensures controlled deployment

7. **Business Users / HR / Managers**
   - Raise requests, approve access, confirm resolution

---

## 6)Summary
- **Service Management = Managing IT services end-to-end with process + tool**
- Ensures **tracking + priority + SLA + ownership + continuous improvement**
- **Implemented by:** ITSM Process Owner + Tool Admin + Service Owners + Service Desk + L2/L3 Teams
