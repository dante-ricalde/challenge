import com.auto1.MyClass
import spock.lang.Specification


/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link MyClassSpec}<br/>
 *
 * @author dante<br/ >
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Dante Raphael Ricalde Delgado. (DRD)</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>Jul 25, 2021 (DRD) Creation class.</li>
 *         </ul>
 * @version 1.0
 */
class MyClassSpec extends Specification {

    def '''testing myMethod'''() {
        given:
        def myClass = new MyClass()
        when:
        def myMethodResponse = myClass.myMethod()
        then:
        myMethodResponse
    }

}