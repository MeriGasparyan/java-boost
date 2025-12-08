package com.merigasparyan.jmp;

public class Task1 {
    public static void main(String[] args) {
        try {
            try {
                if (true) {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.err.print(" 1"); // This gets executed first
            } catch (Exception e) {
                System.err.print(" 2"); // Not executed since Runtime exception already caught
            } finally {
                System.err.print(" 3"); // executed 2nd
            }
        } catch (RuntimeException e) { // nothing to catch
            System.err.print(" 4");
        } catch (Exception e) { // again nothing to catch
            System.err.print(" 5");
        } finally {
            System.err.print(" 6"); // executed 3rd
        }
    }

}
