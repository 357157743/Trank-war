package com.mashibing.tank.ASM;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static aj.org.objectweb.asm.Opcodes.ASM4;
import static aj.org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * @date 2020/6/3 - 10:43
 */
public class ClassTransformerTest {
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/mashibing/tank/ASM/Tank.class"));

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4,cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access,name,descriptor,signature,exceptions);
                return new MethodVisitor(ASM4,mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC,"TimeProxy","before","()V",false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv,0);
        byte[] b2 = cw.toByteArray();

        String path = (String) System.getProperties().get("user.dir");
        System.out.println("path====="+path);
        File f = new File(path + "/com/mashibing/tank/ASM/");
        f.mkdirs();

        FileOutputStream  fos = new FileOutputStream(new File(path + "/com/mashibing/tank/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();
    }
}
