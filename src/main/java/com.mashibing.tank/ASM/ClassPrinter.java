package com.mashibing.tank.ASM;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;

/**
 * @date 2020/6/3 - 9:57
 */
public class ClassPrinter  extends ClassVisitor {
    public ClassPrinter(){super(ASM4);}

    @Override
    public void visit(int version,int access, String name,String signature,String superName,String[] interfaces){
        System.out.println(name + "  extends  " + superName +"{");
    }

    @Override
    public FieldVisitor visitField(int access, String name, String description, String signature, Object value){
        System.out.println("   " +name);
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access,String name ,String description,String signature,String[] exceptions){
        System.out.println("  " + name + "()");
        return null;
    }

    @Override
    public void visitEnd(){
        System.out.println("}");
    }

    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();

        ClassReader cr = new ClassReader("java.lang.Runnable");

       /* ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/mashibing/tank/ASM/T1.class")
        );*/

        cr.accept(cp,0);
    }

}
