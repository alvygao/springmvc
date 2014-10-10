define(['../lib/jquery'], function() {

	function _excute(options) {
		$.ajax({
			beforeSend : function(options) {

			},
			async : options.async || true,
			type : options.method || 'GET',
			url : options.url,
			// data to be added to query string:
			data : options.data,
			// type of data we are expecting in return:
			contentType : options.contentType || 'application/json',
			dataType : options.dataType || 'json',
			success : function(data) {
				var status = data.code;
				
				if (status != '200') {
					if (options.$ele) {
						account.ajax.setBtnStatus(options.click_times,
								options.$ele, options.waitTime);
					}

					if (options.handleError) {
						options.handleError();
					}
					return;
				}
				if (options.handleSuccess) {
					return options.handleSuccess(data.data);
				}
			},
			
			error : function(xhr, type) {
				//TODO
				alert('网络问题');
			}
		});
	}
	
	return {
		excute: _excute
	};
});
