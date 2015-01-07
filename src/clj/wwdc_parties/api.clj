(ns wwdc-parties.api
  (:require [wwdc-parties.db :as db]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.util.response :refer [resource-response response redirect]]))

(defroutes api-routes
  (GET "/parties" [] (response (db/get-all-parties)))
  (route/resources "/"))

(def api
  (-> api-routes
    (middleware/wrap-json-body)
    (middleware/wrap-json-response)))
