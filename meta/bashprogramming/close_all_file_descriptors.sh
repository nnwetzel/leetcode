"""
Close all file descriptors except stdin(0), stdout(1), stderr(2)
"""

#!/bin/bash
for fd in $(seq 3 1023); do
eval "exec $fd>&-" 2>/dev/null
done