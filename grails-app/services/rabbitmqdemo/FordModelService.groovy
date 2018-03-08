package rabbitmqdemo

import grails.gorm.services.Query
import grails.gorm.services.Service
import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import groovy.transform.CompileDynamic
import net.sourceforge.barbecue.Barcode
import net.sourceforge.barbecue.BarcodeFactory
import net.sourceforge.barbecue.BarcodeImageHandler
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.hibernate.transform.Transformers

interface IFordModelService {
    FordModel get(Long id)
    Number count()
    FordModel save(FordModel fordModel)
    @Query("update ${FordModel fm} set ${fm.views} = ${fm.views} + 1 where $fm.id = $id")
    void updateViews(Long id)
}

@Service(FordModel)
abstract class FordModelService implements  IFordModelService {

    @CompileDynamic
    @ReadOnly
    List<FordModel> findAll() {
        BuildableCriteria c = FordModel.createCriteria()
        c.list {
            resultTransformer(Transformers.aliasToBean(FordModelImage))
            projections {
                property('id', 'id')
                property('image', 'image')
                property('name', 'name')
            }
        }
    }

    @Transactional
    void increment(Long id) {
//        FordModel fordModel = get(id)
//        fordModel.views += 1
//        save(fordModel) // Takes advantage of VERSION field
        updateViews(id) // Does not take into account the VERSION field
    }

    String getBarcode(FordModel fordModel) {
        Barcode barcode = BarcodeFactory.createCode128B(fordModel.name) // Default width 18, height 242
        barcode.setBarHeight(36)
        ByteArrayOutputStream img = new ByteArrayOutputStream()
        BarcodeImageHandler.writePNG(barcode, img)
        byte[] bytes = img.toByteArray()
        "data:image/png;base64," + bytes.encodeBase64().toString()
    }
}
