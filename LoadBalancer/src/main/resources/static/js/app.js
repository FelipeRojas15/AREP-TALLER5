var app = (function () {

  var add = function() {
      var valor = $("#data").val();
      apiclient.insertData(valor, view);
  }
   var view = function(error, res) {
    if(error != null){
        alert("Vuelva a intentarlo");
        return;
    }
      alert(res);
    }

    return {
  	  insertData: function() {
            add();
      }

    }

 })();