package cn.albumenj.view;

import cn.albumenj.util.commandlineutil.Print;

/**
 * @author Albumen
 */
public abstract class Menu {
    public int show(){
        Print.flush();
        Print.printLine();

        int result = page();

        Print.printLine();

        return result;
    }

    /**
     * @return 选择页面的数字代号
     */
    abstract public int page();
}
