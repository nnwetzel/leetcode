"""
Simulate and track data center failures.
"""

from datetime import datetime
import heapq

class DataCenterSimulator:
    def __init__(self):
        # server_id -> status ("active" or "failed")
        self.servers = {}

        # min-heaps of scheduled events: (time, server_id)
        self.failure_events = []
        self.recovery_events = []

    def add_failure(self, server_id, failure_time):
        """Schedule a server failure event."""
        heapq.heappush(self.failure_events, (failure_time, server_id))

    def add_recovery(self, server_id, recovery_time):
        """Schedule a server recovery event."""
        heapq.heappush(self.recovery_events, (recovery_time, server_id))

    def simulate_until(self, end_time):
        """Run the simulation and return all events up to end_time."""
        events = []

        # collect all failure events up to end_time
        for time, server in self.failure_events:
            if time <= end_time:
                events.append((time, server, 'failure'))

        # collect all recovery events up to end_time
        for time, server in self.recovery_events:
            if time <= end_time:
                events.append((time, server, 'recovery'))

        # sort combined events by time
        events.sort()

        timeline = []

        # process events in chronological order
        for time, server, event_type in events:

            if event_type == 'failure':
                self.servers[server] = 'failed'
            else:
                self.servers[server] = 'active'

            timeline.append({
                'time': time,
                'server': server,
                'event': event_type,
                'total_failed': sum(
                    1 for s in self.servers.values() if s == 'failed'
                )
            })

        return timeline

def get_availability(self, start_time, end_time):
    """Calculate availability percentage based on events between start_time and end_time."""

    # re-run simulation to get all events up to end_time
    events = self.simulate_until(end_time)

    # filter to the time window
    window_events = [
        e for e in events
        if e['time'] >= start_time
    ]

    # if no events happened in the window, assume 100% availability
    if not window_events:
        return 100.0

    total = len(window_events)
    failed_events = sum(
        1 for e in window_events
        if e['event'] == 'failure'
    )

    # simple event-based availability
    availability = (total - failed_events) / total * 100
    return availability