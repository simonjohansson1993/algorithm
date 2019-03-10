//MGDB1:
db.delegates.find()
//MGDB2:
db.delegates.count()
//MGDB3:
db.conferences.find({}, {_id:1})
//MGDB4:
db.conferences.find({co_located_with: "ICSE'41"})
//MGDB5:
db.conferences.find({"duration.end": {$gt:('2019-04-15')}})
//MGDB6:
db.delegates.find({},{name:1, country:1, _id:0})
//MGDB7:
db.conferences.find({$where: "this.tracks.length >1"})
//MGDB8:
db.conferences.find({name: /ICSE/})
//MGDB9:
db.delegates.update({name: "Sonia Haiduc"},{$set: {country:"Australia"}})
//MGDB10
db.delegates.update({name: "Michael Whalen"}, {$set: {attends: [{conference : "ICSE'42", registered:"2019/02/01"}]}})
//MGDB11
db.delegates.find({"country": "USA","attends":{$exists:true, $ne: null}}).count()
//MGDB12

