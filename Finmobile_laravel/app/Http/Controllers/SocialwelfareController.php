<?php

namespace App\Http\Controllers;

use App\Model\socialwelfare;
use Illuminate\Http\Request;

class SocialwelfareController extends Controller
{
    /**
   * Display a listing of the resource.
   *
   * @return \Illuminate\Http\Response
   */
  public function index()
  {
      return Socialwelfare::all();
  }

  /**
   * Show the form for creating a new resource.
   *
   * @return \Illuminate\Http\Response
   */
 


  /**
   * Display the specified resource.
   *
   * @param  \App\Model\Socialwelfare$socialwelfare
   * @return \Illuminate\Http\Response
   */
  public function show(Socialwelfare $socialwelfare)
  {
      try{
          return $socialwelfare;
       }
      catch(Exception $e){
          return response('Failed to retrieve',220);
      }
  }
  public function store(Request $request)
  {
      try{
          Socialwelfare::create($request->all());
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
   * @param  \App\Model\Socialwelfare  $socialwelfare
   * @return \Illuminate\Http\Response
   */
  public function update(Request $request, Socialwelfare $socialwelfare)
  {
      try{
          $socialwelfare->update($request->all());
          return response('updated', 200);
      }
      catch(Exception $e){
          return response('failed to update data', 220);
      }
  }

  /**
   * Remove the specified resource from storage.
   *
   * @param  \App\Model\Socialwelfare  $socialwelfare
   * @return \Illuminate\Http\Response
   */
  public function destroy(Socialwelfare $socialwelfare)
  {
      try{
          $socialwelfare->delete();
          return response('deleted', 200);
      }
      catch(Exception $e){
          return response('Failed to delete data', 220);
      }
  }
}
