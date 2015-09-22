package business_logic;


public enum MessageType {
    EMPLOYEE {
        @Override
        public String toString() {
            return "Company member";
        }
    },
    TEAM {
        @Override
        public String toString() {
            return "Team";
        }
    },
    ALL {
        @Override
        public String toString() {
            return "All";
        }
    },
}
