# What is Process Management in Linux?
Process management in Linux refers to the control and monitoring of all running processes on the system. It is handled by the Linux kernel, which allocates resources, schedules processes on the CPU, and terminates them when required.

## Process
A process is an **instance of a program currently running** on a computer system. In Linux, processes are managed by the operating system's kernel, which allocates system resources and schedules processes to run on the CPU. Understanding and managing processes is a critical skill for Linux administrators and developers.

## Types of Processes
In Linux, processes can be categorized into two types:

##  Foreground Processes
Foreground processes are the **kinds of processes that require input from the user and are characterized by their interactivity**. For instance, a foreground process would be like you are running an Office application on the Linux system.

## Background Processes

On the other hand, background processes are **non-interactive operations carried out in the background and do not call for any participation from the user**. Antivirus software is an example of a Background Process.

Additionally, processes can be system processes or user processes. System processes are initiated by the kernel, while users initiate User processes.

## 🔄 Process States in Linux
| State        | Description                                        |
| ------------ | -------------------------------------------------- |
| **Running**  | Actively using CPU or ready to run                 |
| **Sleeping** | Waiting for a resource (e.g., I/O)                 |
| **Stopped**  | Execution paused by signal                         |
| **Zombie**   | Completed execution but waiting for parent cleanup |
| **Orphan**   | Parent has terminated but still running            |


## What is Process Management in Linux?
Process management is the task of controlling and monitoring the processes that are running on a Linux system. It involves managing process resources, scheduling processes to run on the CPU, and terminating processes when required.

## Commands for Process Management in Linux
| Command   | Purpose                                   |
| --------- | ----------------------------------------- |
| `ps`      | List current processes                    |
| `top`     | Real-time process usage overview          |
| `kill`    | Terminate a process by PID                |
| `killall` | Terminate all processes with a given name |
| `nice`    | Set priority for a new process            |
| `renice`  | Change priority of existing process       |
| `bg`      | Send a process to background              |
| `fg`      | Bring a background process to foreground  |
| `pidof`   | Show process ID of a process              |


# Signal Basics
| Signal  | Number | Meaning                 |
| ------- | ------ | ----------------------- |
| SIGTERM | 15     | Graceful stop (default) |
| SIGKILL | 9      | Force kill              |
| SIGSTOP | 19     | Pause process           |
| SIGCONT | 18     | Resume process          |
| SIGHUP  | 1      | Reload / hangup         |
| SIGINT  | 2      | Ctrl+C                  |

Ways to Kill a Process
## ✅ Method 1: kill -15 (Recommended First)
Step 1: Find PID
ps -ef | grep sleep


Example:

user  2345  1  sleep 600

Step 2: Kill
kill -15 2345


📌 This allows:

Cleanup

File closing

Safe shutdown

✅ Method 2: kill (Default = -15)
kill 2345


Same as:

kill -15 2345

❌ Method 3: kill -9 (LAST RESORT)
kill -9 2345


⚠️ Danger:

No cleanup

No file close

Possible data corruption

Use only if process is stuck.
##  Method 4: Pause a Process
kill -STOP 2345


Process is frozen.

Check:

ps -ef | grep 2345

▶ Resume a Process
kill -CONT 2345

### ✅ Method 5: Kill by Name (pkill, killall)
Kill all processes with name
pkill sleep


or

killall sleep


⚠️ Be careful — kills ALL matching processes

5️⃣ Real-World Kill Strategy (BEST PRACTICE)
Always follow this order:
1️⃣ kill -15 PID   (graceful)
2️⃣ wait a few seconds
3️⃣ kill -9 PID    (force only if needed)