
package business_logic;


public enum Experience {
    JUNIOR {
        @Override
        public String toString() {
            return "Junior";
        }
    },
    REGULAR {
        @Override
        public String toString() {
            return "Regular";
        }
    },
    SENIOR {
        @Override
        public String toString() {
            return "Senior";
        }
    },
    MANAGER {
        @Override
        public String toString() {
            return "Manager";
        }
    },
    ADMINISTRATOR {
        @Override
        public String toString() {
            return "Administrator";
        }
    }
}
