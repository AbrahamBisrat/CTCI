package amazon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Amazon Device Security needs to know if a Device’s state change should trigger deny/allow listing that
	controls the devices ability on supporting certain features on the device.
	1. If a device&#39;s end state is &quot;OUT_OF_USE&quot;, the utility should put the Device to DENY listing section in
	the output file.
	2. If a device&#39;s end state is “IN_STORAGE”, the utility should put the Device to ALLOW listing section in
	the output file.
	
	Same Device /dsn could show-up number of times with different time stamp, different start to end state
	and the one with the latest time stamp determines under which bucket the given DSN should be marked
	under.
	
	A daily Input log file would look like below:
	
	Explanation:
	(dsn - Device Serial Number)
	{datetime} {dsn} {begin_state} -&gt; {end_state} implies state transition for the dsn, at that datetime.
	
	--------- Input File Starts ------------------------------------
	2020-06-15T20:00:44,318 DSN001 IN_USE -&gt; OUT_OF_USE
	2020-06-15T20:23:35,019 DSN001 IN_STORAGE -&gt; OUT_OF_USE
	2020-06-15T20:23:06,840 DSN002 OUT_OF_USE -&gt; IN_STORAGE
	2020-06-15T20:00:44,318 DSN003 IN_USE -&gt; OUT_OF_USE
	2020-06-15T20:00:44,318 DSN004 IN_USE -&gt; OUT_OF_USE
	2020-06-15T20:23:06,840 DSN004 OUT_OF_USE -&gt; IN_STORAGE
	2020-06-15T20:23:06,840 DSN001 OUT_OF_USE -&gt; IN_STORAGE
	
	--------- Input File Ends --------------------------------------
	
	output file to look like below:
	
	--------- Output File Starts ------------------------------------
	DSNs under DENY LIST:
	DSN001
	DSN003
	
	DSNs under ALLOW LIST:
	DSN002
	DSN004
	--------- Output File Ends --------------------------------------
	
	Explanation:
	DSN001 has 3 entries with different time stamp &amp; different state change for each of them. The one with
	the latest time stamp is going to ‘OUT_OF_USE”  state and so should go under deny listing. 
	DSN003&#39;s start state is IN_USE and end state is OUT_OF_USE, so needs to be added to deny list.
	DSN002&#39;s start state is OUT_OF_USE and end state is IN_STORAGE, so needs to be allow listed.
	DSN004&#39;s start state is OUT_OF_USE and end state is IN_STORAGE, so needs to be allow listed.
	 
	** Note:
	1. timestamps in the input file will NOT be in order.
	2. for any given DSN, you can assume there will not be duplicate timestamps.
	
	Requirement:
	Please write only one function, using the optimal DS (for handling Time/Space Complexity) and objects to
	solve this problem
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class LogFiles_Assesment {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(String[] arr) { p(Arrays.toString(arr)); }

	public static void main(String[] args) {
		String[] logs = {
			"2020-06-15T20:00:44,318 DSN001 IN_USE -&gt; OUT_OF_USE",
			"2020-06-15T20:23:35,019 DSN001 IN_STORAGE -&gt; OUT_OF_USE",
			"2020-06-15T20:23:06,840 DSN002 OUT_OF_USE -&gt; IN_STORAGE",
			"2020-06-15T20:00:44,318 DSN003 IN_USE -&gt; OUT_OF_USE",
			"2020-06-15T20:00:44,318 DSN004 IN_USE -&gt; OUT_OF_USE",
			"2020-06-15T20:23:06,840 DSN004 OUT_OF_USE -&gt; IN_STORAGE",
			"2020-06-15T20:23:06,840 DSN001 OUT_OF_USE -&gt; IN_STORAGE" };
		generateAllowDenyList(logs);
	}
	/* Time Complexity -> O(log inputs (n)) + O(number of devices) === O(n)
	 * Space Complexity -> O(number of devices(hashmap)) + O(allowed devices) + O(denied devices)
	 * === O(n)
	 */
	private static void generateAllowDenyList(String[] logs) {
		if(logs == null || logs.length == 0) return;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss,SSS");
		
		// <device Id, latest log entry>
		Map<String, String> latestLogEntry = new HashMap<>(); // O(number of devices) storage
		for(String log : logs) {								// O(n) TC
			String deviceId = log.split(" ")[1];
			if(!latestLogEntry.containsKey(deviceId)) {
				latestLogEntry.put(deviceId, log);
			} else {
				// compare, and if current is latest, keep current, move on otherwise.
				String existingDate = latestLogEntry.get(deviceId).split(" ")[0];
				String currentLogDate = log.split(" ")[0];
				
				LocalDateTime logTimeOne = LocalDateTime.parse(existingDate, formatter);
				LocalDateTime logTimeTwo = LocalDateTime.parse(currentLogDate, formatter);
				
				if(logTimeTwo.compareTo(logTimeOne) == 1) latestLogEntry.put(deviceId, log);
			}
		}
		List<String> allowedDevices = new ArrayList<>(); // O(number of allowed devices) - storage
		List<String> deniedDevices = new ArrayList<>();  // O(number of denied devices) - storage
		
		for(Map.Entry<String, String> deviceLatestLog : latestLogEntry.entrySet()) { // O(number of devices) TC
			String[] logArray = deviceLatestLog.getValue().split(" ");
			String state = logArray[logArray.length - 1];
			if(state.equals("IN_STORAGE"))
				allowedDevices.add(deviceLatestLog.getKey());
			else deniedDevices.add(deviceLatestLog.getKey());
		}
		
		System.out.println("DSNs under DENY LIST:");
		deniedDevices.forEach(System.out::println);		// O(denied devices)
		
		System.out.println("\nDSNs under ALLOW LIST:");
		allowedDevices.forEach(System.out::println);    // O(allowed devices)
	}
}
