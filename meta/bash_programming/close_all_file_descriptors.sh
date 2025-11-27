"""
Close all file descriptors except stdin(0), stdout(1), stderr(2)
"""

#!/bin/bash
# for file descriptors 3 to 1023
# seq means generate sequence from 3 to 1023
for fd in $(seq 3 1023); do
# close the file descriptor if it's open
eval "exec $fd>&-" 2>/dev/null
done