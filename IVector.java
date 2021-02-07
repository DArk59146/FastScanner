public class IVector {
        private int size;
        private int[] vector;
        private int remain;
        
        public IVector(int size) {
            vector = new int[size];
            this.size = size;
            remain = size;
        }
        
        public int size() {
            return size;
        }
        
        public int length() {
            return size - remain;
        }
        
        public int get(int poz) {
            return vector[poz];
        }
        
        public void add(int value) {
            if (remain != 0) {
                vector[size-remain] = value;
                remain--;
            } else {
                int[] buf = new int[size*2];
                System.arraycopy(vector, 0, buf, 0, size);
                vector = buf;
                remain = size;
                size *= 2;
                add(value);
            }
        }
        
        public void set(int poz, int val) {
            if (poz < size-remain) {
                vector[poz] = val;
            }
        }
        
        public static void main(String[] args) {
        }
}
