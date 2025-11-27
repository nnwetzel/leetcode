"""
Problem: Execute tasks on multiple remote servers in parallel.
"""

#!/bin/bash

# list of remote servers
servers=("server1" "server2" "server3")
# maximum number of parallel jobs
max_jobs=5

# function to execute a command on a remote server
remote_task() {
    local server=$1
    # example command: get uptime and disk usage
    ssh "$server" 'uptime; df -h'
}

# run tasks in parallel
for server in "${servers[@]}"; do
    # wait if we've reached max parallel jobs
    while [ "$(jobs -r | wc -l)" -ge "$max_jobs" ]; do
        # wait for any job to finish
        sleep 0.1
    done

# wait for all jobs to complete
wait