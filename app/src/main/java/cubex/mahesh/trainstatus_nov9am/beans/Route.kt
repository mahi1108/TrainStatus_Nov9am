package cubex.mahesh.trainstatus_nov9am.beans

data class Route(
    var actarr:String,
    var actdep:String,
    var scharr:String,
    var schdep:String,
    var station: Station,
    var status:String
)