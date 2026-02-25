# JIRA Training Notes (Beginner → Job-Ready)

**Topics Covered:** Introduction to JIRA • Working with Issues • JIRA Workflows • JIRA Administration • Agile Boards (Scrum/Kanban) • Reporting • Dashboards

---

## 1) Introduction to JIRA (What & Why)

### What is JIRA?
Jira (by Atlassian) is a **work management + issue tracking tool** used to plan, track, and release software (and even non-software) work.

### Why companies use Jira
- Central place for **requirements + tasks + bugs**
- Clear **ownership** (assignee), **status**, and **priority**
- Team collaboration via **comments, mentions, attachments**
- Supports **Agile** (Scrum/Kanban) with boards & sprints
- **Reports + dashboards** for tracking progress

### Key Terms (must know)
- **Project**: container for work (Software, Business, Service)
- **Issue**: a work item (Story, Bug, Task, Epic…)
- **Workflow**: issue status flow (To Do → In Progress → Done)
- **Board**: visual view of work (Scrum/Kanban)
- **Sprint**: time-boxed iteration (Scrum)
- **Backlog**: prioritized list of pending issues

---

## 2) Working with Issues in JIRA (Daily Work)

### Common issue types (Agile project)
- **Epic**: big feature (contains many stories/tasks)
- **Story**: user requirement (“As a user, I want…”)
- **Task**: general work item
- **Bug**: defect / issue
- **Sub-task**: part of a story/task

### Creating an Issue (step-by-step)
1. Click **Create**
2. Select **Project**
3. Choose **Issue Type** (Story/Bug/Task)
4. Fill:
   - **Summary** (short title)
   - **Description** (details, steps, acceptance criteria)
   - **Priority** (High/Medium/Low)
   - **Assignee**
   - **Labels/Components** (optional)
5. Click **Create**

### Best-practice templates

**Story**
- Description: business goal
- **Acceptance Criteria** (Given/When/Then)
- UI/API notes if any

**Bug**
- Steps to Reproduce
- Actual Result
- Expected Result
- Environment (Browser, Build, OS)
- Screenshots/logs

### Searching & filters (power skill)
- Use search to find issues fast (project, assignee, status, sprint).
- Save searches as **Filters** (used later in dashboards).

### Key issue operations
- **Edit**, **Comment**, **Attach files**
- **Watch** issue (get updates)
- **Link issues** (blocks / relates to / duplicates)
- **Move** issue (change project/type)
- **Clone** issue (copy)

---

## 3) JIRA Workflows (Statuses + Transitions)

### What is a Workflow?
A workflow defines:
- **Statuses** (To Do, In Progress, QA, Done…)
- **Transitions** (move from one status to another)
- Rules like **approvals**, **mandatory fields**, **validators**

### Typical workflow examples

**Simple**
- To Do → In Progress → Done

**With QA**
- To Do → In Progress → Code Review → QA Testing → Done

### Workflow building blocks
- **Status**: current stage of the issue
- **Transition**: action to move between statuses
- **Conditions**: who can transition (e.g., only QA role)
- **Validators**: checks before transition (e.g., fix version required)
- **Post Functions**: automatic actions after transition (e.g., set resolution)

### Real-world tips
- Keep workflow **simple for teams**, add complexity only when needed
- Create different workflows for:
  - Bugs (needs QA step)
  - Stories (needs UAT step)
  - Service requests (approval step)

---

## 4) JIRA Administration (Core Admin Concepts)

> Admin tasks depend on whether you are using **Jira Cloud** or **Jira Data Center/Server**, but concepts are similar.

### Admin roles
- **Jira Admin**: global settings
- **Project Admin**: project-level settings

### Common admin responsibilities
1. **User Management**
   - Add users, groups, roles (Dev, QA, PO)
   - Set permissions
2. **Project Configuration**
   - Issue types, screens, fields
   - Components, versions, releases
3. **Permissions & Security**
   - Who can create/edit/transition issues
   - Restrict sensitive projects
4. **Workflow Management**
   - Create/modify workflows
   - Attach workflows to issue types via workflow schemes
5. **Field Configuration**
   - Required fields
   - Hide/show fields by issue type

### Permission concepts (must know)
- **Project Roles** (Developer, Tester, Admin…)
- **Groups** (Org-wide grouping)
- **Permission Scheme** controls:
  - Browse, Create, Edit, Assign, Transition, Resolve, Delete

---

## 5) Agile Boards (Scrum & Kanban)

### A) Scrum Board (Sprint-based)

**Used when:**
- You work in **iterations** (1–4 weeks)
- You plan a sprint, commit work, deliver increment

**Scrum concepts in Jira**
- **Backlog**: list of upcoming work
- **Sprint**: selected work for iteration
- **Velocity**: completed work trend per sprint

**Scrum workflow (practical)**
1. Create Epic → create Stories under Epic
2. Prioritize stories in **Backlog**
3. Click **Create Sprint**
4. Drag stories into sprint
5. **Start Sprint**
6. Team moves work across board
7. **Complete Sprint**
8. Use reports: burndown, velocity

### B) Kanban Board (Continuous flow)

**Used when:**
- Work arrives continuously (support/ops/maintenance)
- You want to limit work-in-progress (WIP)

**Kanban key concepts**
- **WIP Limits** (e.g., max 3 items in “In Progress”)
- **Cycle Time** (how long an issue takes start→done)
- **Throughput** (issues completed per time)

**Kanban workflow (practical)**
1. Create issues
2. Pull work into “In Progress”
3. Enforce WIP limits
4. Track flow using control chart / cumulative flow

---

## 6) Reporting in JIRA (How managers track progress)

### Common Jira reports (Scrum)
- **Sprint Burndown**: remaining work vs time
- **Velocity Chart**: sprint-by-sprint completion trend
- **Epic Burndown**: progress on an epic
- **Release Burndown**: release readiness

### Common Jira reports (Kanban)
- **Control Chart**: cycle time distribution
- **Cumulative Flow Diagram**: bottlenecks & WIP trends

### Reporting tips
- Keep statuses accurate
- Estimate consistently
- Close issues properly (resolution)

---

## 7) Dashboards (Executive View in 1 Page)

### What is a Dashboard?
A dashboard is a collection of **gadgets** that show live metrics from your Jira data.

### Examples of useful dashboards
**Team Dashboard**
- Sprint progress
- Issues by assignee
- Issues by status
- Burndown chart

**QA Dashboard**
- Open bugs by priority
- Bugs created vs resolved
- Bugs by component/module

**Manager Dashboard**
- Velocity
- Epic progress
- Release readiness
- Blocked issues count

### Popular gadgets
- Filter Results
- Pie Chart (by status/priority)
- Sprint Health / Sprint Burndown
- Created vs Resolved
- Two-Dimensional Filter Statistics

### How dashboards are built
1. Create a **Filter** (saved search)
2. Create dashboard
3. Add gadgets and connect each gadget to a filter
4. Share dashboard with project/team

---

## Mini Hands-on Practice (Recommended)

### Practice 1: Issue lifecycle
- Create Epic → Story → Sub-task → move through statuses → close

### Practice 2: Scrum Sprint
- Create sprint → add 8–10 issues → start sprint → complete sprint → view burndown

### Practice 3: Kanban flow
- Create 10 issues → set WIP limit → move issues → view control chart/cumulative flow

### Practice 4: Dashboard
- Create filter “My open issues”
- Add gadgets: Filter Results + Pie chart + Created vs Resolved
