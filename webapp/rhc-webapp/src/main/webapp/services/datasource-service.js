/*
 * Service to fetch data from data source
 */
app
    .service(
        'datasource',
        function ($http, strings, serverEndpoints) {

            /*
             * Fetch data from data source
             */
            var makeHttpCall = function (vUrl, vMethod, vData, vHeaders) {

                return $http({
                    method: vMethod,
                    url: vUrl,
                    data: vData,
                    headers: vHeaders,
                    cache: false
                });
            };

            var getData = function (url, requestData, requestHeaders,
                                    handler) {
            	
                var fullAddress = "";

                fullAddress = serverEndpoints.baseUrl + url;

                makeHttpCall(fullAddress, dataFetchMethod.GET,
                    requestData, requestHeaders)
                    .then(
                        function (response) {

                            if (response != null
                                && response.data != null) {
                                var operationStatus = response.data[serverEndpoints.operationStatus];

                                if (operationStatus == STATUS.OPERATIONSUCCESSFULL) {
                                    var resultSet = response.data[serverEndpoints.resultSet];
                                    handler(true, resultSet);
                                } else {
                                    handler(
                                        false,
                                        getErrorMessageForOperationStatusCode(operationStatus));
                                }
                            } else {
                                handler(false, null);
                            }

                        }, function (response) {
                            handler(false, "Network error!");
                        });
            }

            /*
             * File upload
             */
            var updateFile = function (file, fileId, vAuthToken, handler) {
                var fd = new FormData();
                var uploadUrl = serverEndpoints.baseUrl;
                fd.append(serverEndpoints.fileContent, file);

                if (fileId != null) {
                    fd.append(serverEndpoints.fileId, fileId);
                    uploadUrl = uploadUrl + serverEndpoints.updateFileUrl;
                } else {
                    uploadUrl = uploadUrl + serverEndpoints.uploadFileUrl;
                }

                var vHeaders = {};
                vHeaders[serverEndpoints.authToken] = vAuthToken;
                vHeaders[serverEndpoints.contentType] = undefined;

                return $http
                    .post(uploadUrl, fd, {
                        transformRequest: angular.identity,
                        headers: vHeaders
                    })
                    .then(
                        function (response) {

                            if (response != null
                                && response.data != null) {
                                var operationStatus = response.data[serverEndpoints.operationStatus];

                                if (operationStatus == STATUS.OPERATIONSUCCESSFULL) {
                                    var resultSet = response.data[serverEndpoints.resultSet];
                                    handler(true, resultSet);
                                } else {
                                    handler(
                                        false,
                                        getErrorMessageForOperationStatusCode(operationStatus));
                                }
                            } else {
                                handler(false, null);
                            }

                        }, function (response) {
                            handler(false, "Network error!");
                        });
            };

            /*
             * Data Fetch Method ENUM
             */
            var dataFetchMethod = {
                GET: 'GET',
                POST: 'POST'
            };

            /*
             * Operation status
             */

            var STATUS = {
                ALCOHOLLEVELNULL: -3,
                DEVICESERIALNULL: -2,
                REMOTESERVERDOWN: -50,
                OPERATIONSUCCESSFULL: 1,
                UNKNOWNERROR: -1
            };

            var getErrorMessageForOperationStatusCode = function (operationStatusCode) {
                if (operationStatusCode == STATUS.REMOTESERVERDOWN) {
                    return strings.msg_remote_server_down;
                } else if (operationStatusCode == STATUS.UNKNOWNERROR) {
                    return strings.msg_unknown_error;
                } else {
                    return strings.msg_unknown_error;
                }
            };

            return {
                getData: getData,
                updateFile: updateFile
            }
        });