<?php

namespace App\Http\Controllers;

use App\Model\Registration;
use Illuminate\Http\Request;

class RegistrationController extends Controller
{
      /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        return Registration::all();
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
   
  

    /**
     * Display the specified resource.
     *
     * @param  \App\Model\Registration  $registration
     * @return \Illuminate\Http\Response
     */
    public function show(Registration $registration)
    {
        try{
            return $registration;
         }
        catch(Exception $e){
            return response('Failed to retrieve',220);
        }
    }
    public function store(Request $request)
    {
        try{
            Registration::create($request->all());
            return response("created",201);
        }
        catch(\Throwable $th){
            return response("failed",220);
        }
    }
  /**
     * Show the form for editing the specified resource.
     *
     * @param \Illuminate\Http\Request $request
     * @param  \App\Model\Registration  $registration
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Registration $registration)
    {
        try{
            $registration->update($request->all());
            return response('updated', 200);
        }
        catch(Exception $e){
            return response('failed to update data', 220);
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Model\Registration  $registration
     * @return \Illuminate\Http\Response
     */
    public function destroy(Registration $registration)
    {
        try{
            $registration->delete();
            return response('deleted', 200);
        }
        catch(Exception $e){
            return response('Failed to delete data', 220);
        }
    }
}
