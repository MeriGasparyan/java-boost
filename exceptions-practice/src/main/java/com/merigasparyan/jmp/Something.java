package com.merigasparyan.jmp;

import com.merigasparyan.jmp.task4.CustomUncheckedException;

public class Something {
    private int value;
    public Something(int value) {
        try{
            throw new CustomUncheckedException("Something is wrong");
        }catch (CustomUncheckedException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            this.value=value;
        }
    }

    @Override
    public String toString() {
        return "Something{" +
                "value=" + value +
                '}';
    }
}
