package rabbitmqdemo

import net.sourceforge.barbecue.Barcode
import net.sourceforge.barbecue.BarcodeFactory
import net.sourceforge.barbecue.BarcodeImageHandler

class FordModel {
    Long id
    String image
    String name
    String driveline
    String href
    String description
    Integer views
    static mapping = {
        table 'fordmodel'
        image nullable: false
        name nullable: false
        driveline nullable: false
        href nullable: false
        id generator: 'increment'
    }

    static constraints = {
    }
}
