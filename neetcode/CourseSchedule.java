class Solution {
    // THOUGHT PROCESS:
    // Detect cycles in the prerequisite graph using DFS. We keep a 'visiting' set for nodes
    // on the current DFS path — if a course appears in 'visiting' again, there's a cycle.
    // Once a course is verified, add it to 'visited' to avoid re-checking.
    // Time: O(V + E). Space: O(V).

    Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();

    // PSEUDOCODE:
    // 1. Build adjacency list: course -> list of prerequisites.
    // 2. For each course, run dfs to check for cycles. If any dfs finds a cycle, return false.
    // 3. If all courses pass, return true.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build adjacency list
        // example: {0: [], 1: []}
        for (int i = 0; i < numCourses; i++) preMap.put(i, new ArrayList<>());
        // example: {0: [1], 1: []}
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            preMap.get(course).add(pre);
        }

        // check every course for cycles
        for (int c = 0; c < numCourses; c++) if (!dfs(c)) return false;
        return true;
    }

    // PSEUDOCODE:
    // 1. If course is on current DFS path -> cycle -> return false.
    // 2. If course has no prerequisites -> return true.
    // 3. Mark course as visiting, DFS each prereq; if any fails, return false.
    // 4. Remove course from visiting, add course to visited, return true.
    public boolean dfs(int course) {
        // stop if cycle detected (course already in current path)
        if (visiting.contains(course)) return false;
        // no prerequisites, course is verified
        if (visited.contains(course)) return true;

        // mark course as being visited on current path
        visiting.add(course);
        // visit all prerequisites and check for cycles
        for (int pre : preMap.get(course)) if (!dfs(pre)) return false;

        // done exploring, remove from visiting because no cycle found
        visiting.remove(course);
        // mark course as visited because it's verified
        visited.add(course);
        return true;
    }
}