package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-12-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-12-20
 */

class Logger_rate_limiter {
    class Logger {
        private Map<String, Integer> logs = new HashMap<>();
        private static final int TEN_S = 10;

        /** Initialize your data structure here. */
        public Logger() {

        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public synchronized boolean shouldPrintMessage(int timestamp, String message) {
            if (logs.containsKey(message)) {
                int time = logs.get(message);
                if (timestamp < time) {
                    logs.replace(message, timestamp);
                    return false;
                }
                if (timestamp - time < TEN_S) {
                    return false;
                }
                logs.replace(message, timestamp);
                return true;
            } else {
                logs.put(message, timestamp);
                return true;
            }
        }


    }
}
