package rabbitmqdemo

class FordModelController {

    static allowedMethods = [index: 'GET', show: 'GET']
    FordModelService fordModelService

    def index() {
        [fordModelList : fordModelService.findAll()]
    }

    def show(Long id) {
        FordModel fordModel = fordModelService.get(id)
        String barcode = fordModelService.getBarcode(fordModel)
        [fordModelInstance: fordModel, barcode: barcode]
    }
}
