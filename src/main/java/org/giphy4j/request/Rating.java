package org.giphy4j.request;

/**
 * Possible ratings to pick while requesting search Endpoint
 */
public enum Rating {
    Y{
        @Override
        public String toString() {
            return "Y";
        }
    },
    G{
        @Override
        public String toString() {
            return "G";
        }
    },
    PG{
        @Override
        public String toString() {
            return "PG";
        }
    },
    PG13{
        @Override
        public String toString() {
            return "PG-13";
        }
    },
    R{
        @Override
        public String toString() {
            return "R";
        }
    }
}
