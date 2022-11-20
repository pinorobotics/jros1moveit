/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
open module jros1moveit.tests {
    requires jros1client;
    requires jros1moveit;
    requires jrosmoveit.tests;
    requires jros1rviztools;
    requires id.xfunction;
    requires org.junit.jupiter.api;
    requires jros1tf2;

    exports pinorobotics.jros1moveit.tests;
}
