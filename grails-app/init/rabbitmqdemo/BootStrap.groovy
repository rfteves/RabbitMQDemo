package rabbitmqdemo

class BootStrap {

    public final List< Map<String, String> > CARS = [
            [
                    name : 'Fiesta',
                    driveline: 'FWD',
                    href: 'https://www.ford.com/cars/fiesta/2018/',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/staging/en_us/ford/nameplate/fiesta/2018/collections/adplanners/2018_fiesta_nav.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "Any driving enthusiast can tell you the story behind performance, starting with exhilarating power. Fiesta ST packs a turbocharged and direct-injected 197-hp68 1.6L EcoBoost® engine mated to a slick-shifting six-speed manual transmission."
            ],
            [
                    name : 'Focus',
                    driveline: ' Eric Helgeson',
                    href  : 'https://www.ford.com/cars/focus/2018/',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/focus/2018/collections/ad_planners/18_foc_tnm_globalnav_280x121.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "Focus is equipped to maximize the fun factor. Standard Torque Vectoring Control39 is designed to help the front wheels grip and steer better as you go into corners or drive in slippery conditions."
            ],
            [
                    name : 'Fusion',
                    driveline: 'AWD',
                    href  : 'https://www.ford.com/cars/fusion/2018/?gnav=header-all-vehicles',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/fusion/2018/collections/ad_planner/2018-Fusion2x.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "Whether you choose the S Appearance Package with 18-inch magnetic-painted aluminum wheels, the SE Appearance Package with rear spoiler or the SE Luxury Package – the 2018 Ford Fusion has the good looks to go along with its performance and technology."
            ],
            [
                    name : 'C-Max',
                    driveline: 'AWD',
                    href  : 'https://www.ford.com/cars/c-max/2018/?gnav=header-all-vehicles',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/staging/en_us/ford/nameplate/c-max/2018/collections/adplanner/2018_C-Max2x.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "SmartGauge with EcoGuide offers a multitude of customizable LCD displays that help you understand how changing your driving habits can have a direct effect on maximizing vehicle efficiency."
            ],
            [
                    name : 'Mustang',
                    driveline: 'AWD',
                    href  : 'https://www.ford.com/cars/mustang/2018/?gnav=header-all-vehicles',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/mustang/2018/collections/18_frd_mst_globalnav_280x121.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "The new Mustang is designed to custom-fit the way you drive, down to the last detail. From the look of the instrument panel to the sound of its growl to the way it feels taking a curve, this legend was born to make your own."
            ],
            [
                    name : 'Taurus',
                    driveline: 'AWD',
                    href  : 'https://www.ford.com/cars/taurus/2018/?gnav=header-all-vehicles',
                    image: 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/taurus/2018/collections/ad_planners/18_trs_Global-NAV_280x121.png/_jcr_content/renditions/cq5dam.web.1280.1280.png',
                    description: "Taurus exudes sophistication. It cuts a sleek profile, with aerodynamic lines and well-crafted design details. Its bold stance conveys confidence, while the curved silhouette and artful extras add timeless refinement."
            ]
    ]

    def init = { servletContext ->
        def fordModels = []
        for (Map<String, String> car : CARS) {
            FordModel fordModel = FordModel.create()
            fordModel.name = car.name
            fordModel.driveline = car.driveline
            fordModel.href = car.href
            fordModel.image = car.image
            fordModel.description = car.description
            fordModel.views = 0
            fordModels << fordModel
        }

        FordModel.saveAll(fordModels)
    }
    def destroy = {
    }
}
